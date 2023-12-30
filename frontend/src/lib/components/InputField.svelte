<script lang="ts">
  export let value: string;
  export let placeholder: string;

  const capitalize = () => {
    value = value[0].toUpperCase() + value.substring(1);
  };
</script>

<input
  class="text-input"
  type="text"
  {placeholder}
  aria-label={placeholder}
  required
  maxlength="255"
  bind:value
  on:input={capitalize}
/>

<style>
  .text-input {
    background-color: rgba(255, 255, 255, 0);
    width: 100%;
    border: none;
    margin-right: 0.75rem;
    padding: 0.5rem 0.25rem;
    line-height: 1.25;
    font-size: 1rem;
  }

  .text-input:focus {
    outline: none;
  }
</style>
