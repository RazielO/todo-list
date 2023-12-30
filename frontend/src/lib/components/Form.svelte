<script lang="ts">
  import InputField from "./InputField.svelte";
  import SubmitButton from "./SubmitButton.svelte";

  export let action: () => void;
  export let placeholder: string;
  export let value: string;
  export let add: boolean;
  export let buttonText: string;
</script>

<form on:submit|preventDefault={action}>
  <div class="form-inline">
    <InputField {placeholder} bind:value />
    <SubmitButton {add}>{buttonText}</SubmitButton>
  </div>
</form>

<style>
  form {
    width: 100%;
  }

  .form-inline {
    display: flex;
    align-items: center;
    border-bottom: 1px solid #4299E1;
    padding: 0.5rem 0;
  }
</style>
