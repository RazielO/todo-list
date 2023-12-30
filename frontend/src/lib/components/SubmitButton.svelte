<script lang="ts">
  export let add: boolean;
</script>

<button class="btn-submit" class:add class:save={!add} type="submit">
  <slot />
</button>

<style>
  .btn-submit {
    color: white;
    font-weight: bold;
    padding: 0.5rem 1rem;
    border-bottom-width: 4px;
    border-radius: 0.25rem;
  }

  .btn-submit.add {
    background-color: #48bb78;
    border-color: #68d391;
  }

  .btn-submit.add:hover {
    background-color: #68d391;
    border-color: #48bb78;
  }

  .btn-submit.save {
    background-color: #4299e1;
    border-color: #2b6cb0;
  }

  .btn-submit.save:hover {
    background-color: #63b3ed;
    border-color: #4299e1;
  }
</style>
