<script lang="ts">
  import { onMount } from "svelte";
  import type { Todo } from "./lib/types/Todo";

  import "./app.css";

  import Form from "./lib/components/Form.svelte";
  import TodoItem from "./lib/components/TodoItem.svelte";
  import {
    createTodo,
    deleteRequest,
    loadTodos,
    toggleTodo,
    updateRequest,
  } from "./lib/functions/requests";
  import Card from "./lib/components/Card.svelte";

  const toggle = async (id: number) => (todos = await toggleTodo(id));
  const deleteTodo = async (id: number) => (todos = await deleteRequest(id));

  const addTodo = async () => {
    todos = await createTodo(input);
    input = "";
  };

  const updateTodo = async (id: number, newValue: string) => {
    todos = await updateRequest(updateId, newValue);
    updateId = -1;
  };

  let input: string;
  let todos: Todo[] = [];
  let updateId: number;

  const initialLoad = async () => {
    try {
      todos = await loadTodos();
    } catch (error) {
      todos = [];
    }
  };
  onMount(() => initialLoad());
</script>

<main>
  <div class="container">
    <h1 class="font-bold text-3xl text-center w-auto">My To Do List</h1>

    <Form
      action={() => addTodo()}
      placeholder="To Do"
      bind:value={input}
      add={true}
      buttonText="Add"
    />

    {#each todos as todo (todo.id)}
      <Card>
        {#if todo.id === updateId}
          <Form
            action={() => updateTodo(todo.id, todo.todo)}
            placeholder="New Value"
            bind:value={todo.todo}
            add={false}
            buttonText="Save"
          />
        {:else}
          <TodoItem
            {todo}
            toggleFunction={() => toggle(todo.id)}
            updateFunction={() => (updateId = todo.id)}
            deleteFunction={() => deleteTodo(todo.id)}
          />
        {/if}
      </Card>
    {/each}
  </div>
</main>

<style>
  .container {
    max-width: 28rem;
    margin: 0 auto;
    /* padding: 1rem 0; */
  }

  h1 {
    font-weight: bold;
    font-size: 1.875rem;
    line-height: 2.25rem;
    text-align: center;
  }
</style>
