import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SubjectPipe } from '../subject.pipe';

@Component({
  selector: 'app-reactive',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, SubjectPipe],
  templateUrl: './reactive.component.html'
})
export class ReactiveComponent {

  form:FormGroup
  subjectList = ['HTML', 'CSS', 'JS', 'Angular']
  list:any = []

  constructor(private builder:FormBuilder) {
    this.form = builder.group({
      name: ['', Validators.required],
      contact: builder.group({
        phone: ['', Validators.required],
        email: ['', Validators.email]
      }),
      subjects: builder.array([
        builder.control(false),
        builder.control(false),
        builder.control(false),
        builder.control(false)
      ])
    })
  }

  get subjects() {
    return this.form.get('subjects') as FormArray
  }

  save() {
    console.log(this.form)
    if(this.form.valid)
      this.list.push(this.form.value)

    this.form.reset()
  }


}
