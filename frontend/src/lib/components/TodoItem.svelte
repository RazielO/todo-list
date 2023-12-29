<script lang="ts">
  import IconButton from "./IconButton.svelte";

  import trash from "/trash.svg";
  import pen from "/pen.svg";
  import type { Todo } from "../types/Todo";

  export let toggleFunction: () => void;
  export let updateFunction: () => void;
  export let deleteFunction: () => void;
  export let todo: Todo;
</script>

<div class="todo-item">
  <input type="checkbox" on:change={toggleFunction} checked={todo.completed} />
  <span class:done={todo.completed}>
    {todo.todo}
  </span>
</div>
<div class="actions">
  <IconButton edit={true} src={pen} alt="Edit" action={updateFunction} />
  <IconButton edit={false} src={trash} alt="Delete" action={deleteFunction} />
</div>

<style>
  .todo-item,
  .actions {
    display: flex;
    align-items: center;
    gap: 0.5rem;
    overflow: hidden;
  }

  .actions {
    gap: 0.25rem;
  }

  .done {
    color: #cbd5e0;
    text-decoration: line-through;
  }
</style>
