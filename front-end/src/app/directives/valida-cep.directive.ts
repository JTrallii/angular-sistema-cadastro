import { ConsultaCepService } from '../service/consulta-cep/consulta-cep.service';
import { Directive } from '@angular/core';
import { AbstractControl, AsyncValidator, NG_ASYNC_VALIDATORS, ValidationErrors } from '@angular/forms';
import { Observable, map } from 'rxjs';

@Directive({
  selector: '[validadorCep]',
  standalone: true,
  providers: [{
    provide: NG_ASYNC_VALIDATORS,
    useExisting: ValidaCepDirective,
    multi: true
  }]
})
export class ValidaCepDirective implements AsyncValidator {

  constructor(private ConsultaCepService: ConsultaCepService) { }

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    const cep = control.value;

    return this.ConsultaCepService.consultaCep(cep).pipe(map(
      (resultado: any) => resultado.erro ? {"validadorCep": true} : null
    ));
  }
}
