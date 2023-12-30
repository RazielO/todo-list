<div class="card">
  <slot />
</div>

<style>
  .card {
    border-radius: 0.25rem;
    overflow: hidden;
    padding: 1rem 2rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
    --tw-shadow: 0 10px 15px -3px rgb(0 0 0 / 0.1),
      0 4px 6px -4px rgb(0 0 0 / 0.1);
    --tw-shadow-colored: 0 10px 15px -3px var(--tw-shadow-color),
      0 4px 6px -4px var(--tw-shadow-color);
    box-shadow: var(--tw-ring-offset-shadow, 0 0 #0000),
      var(--tw-ring-shadow, 0 0 #0000), var(--tw-shadow);
  }
</style>
