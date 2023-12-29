const BASE_URL = "/todo";

function requestWithoutBody(url: string, method: string): Promise<any> {
    return fetch(url, { method: method, });
}

function requestWithBody(url: string, method: string, body: object): Promise<any> {
    return fetch(url, {
        method: method,
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
    });
}

export async function loadTodos() {
    return await requestWithoutBody(`${BASE_URL}/all`, 'GET')
        .then((response) => {
            if (!response.body || !response.body.getReader) {
                throw new Error('ReadableStream not supported');
            }

            // Get the reader
            const reader: ReadableStreamDefaultReader = response.body.getReader();

            // Accumulate chunks of data
            let chunks = '';

            // Define a function to recursively read chunks
            function readChunk(): any {
                return reader.read().then(({ done, value }) => {
                    if (done) {
                        // Parse accumulated chunks as JSON
                        const jsonData = JSON.parse(chunks);
                        return jsonData;
                    }

                    // Accumulate the chunk of data
                    chunks += new TextDecoder('utf-8').decode(value);

                    // Continue reading the next chunk
                    return readChunk();
                });
            }

            // Start reading chunks
            return readChunk();
        })
}

export async function deleteRequest(id: number) {
    await requestWithoutBody(`${BASE_URL}/${id}`, 'DELETE');
    return await loadTodos();
}

export async function toggleTodo(id: number) {
    await requestWithoutBody(`${BASE_URL}/${id}/toggle`, 'PUT');
    return await loadTodos();
}

export async function createTodo(todo: string) {
    await requestWithBody(BASE_URL, 'POST', { todo: todo });
    return await loadTodos();
}

export async function updateRequest(id: number, todo: string) {
    await requestWithBody(`${BASE_URL}/${id}`, 'PUT', { todo: todo })
    return await loadTodos();
}