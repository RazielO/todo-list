<script lang="ts">
  export let edit: boolean;
  export let src: string;
  export let alt: string;
  export let action: () => void;
</script>

<button class="icon-btn" class:edit class:delete={!edit} on:click={action}>
  <img {src} {alt} width="16px" />
</button>

<style>
  .icon-btn {
    border-radius: 100%;
    padding: 0.5rem;
  }

  .icon-btn.edit {
    background-color: #4299e1;
  }

  .icon-btn.edit:hover {
    background-color: #2b6cb0;
  }

  .icon-btn.delete {
    background-color: #f56565;
  }

  .icon-btn.delete:hover {
    background-color: #c53030;
  }

  img {
    display: block;
  }
</style>
