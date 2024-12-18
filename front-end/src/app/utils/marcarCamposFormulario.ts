import { NgForm } from "@angular/forms";



export default function marcarCamposComoTouched(form: NgForm) {
  // Percorre todos os controles do formulário e marca como touched
  Object.keys(form.controls).forEach((field) => {
    const control = form.controls[field];
    control.markAsTouched();
  });
}
