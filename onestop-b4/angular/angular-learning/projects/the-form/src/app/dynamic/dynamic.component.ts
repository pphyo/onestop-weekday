import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-dynamic',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './dynamic.component.html'
})
export class DynamicComponent {
  form:FormGroup

  constructor(private builder:FormBuilder) {
    this.form = builder.group({
      name: '',
      subjects: builder.array([
        builder.control('')
      ])
    });
  }

  get subjects() {
    return this.form.get('subjects') as FormArray
  }

  addSubject() {
    this.subjects.push(new FormControl)
  }

  removeSubject(index:number) {
    this.subjects.removeAt(index)
  }
}
