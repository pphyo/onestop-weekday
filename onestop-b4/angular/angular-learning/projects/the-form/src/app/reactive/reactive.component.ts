import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-reactive',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive.component.html'
})
export class ReactiveComponent {

  form:FormGroup

  constructor(private builder:FormBuilder) {
    this.form = builder.group({
      name: new FormControl,
      phone: new FormControl,
      email: new FormControl
    })
  }

  save() {
    console.log(this.form)
  }


}
