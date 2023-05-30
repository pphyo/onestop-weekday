import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-template',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './template.component.html'
})
export class TemplateComponent {

  model:any
  subjectList = ['HTML', 'CSS', 'Javascript', 'Angular'];
  list:any = []

  constructor() {
    this.initForm();
  }

  save(form:any) {
    const value = form.value

    value.subjects = Object.entries(value.subjects)
                        .filter(entry => entry[1])
                        .map(entry => entry[0])
                        .map(i => + i)
                        .map(index => this.subjectList[index])

    this.list.push(form.value)
    this.initForm()
  }

  edit(item:any) {

  }

  initForm() {
    this.model = {
      name: '',
      contact: {
        phone: '',
        email: ''
      },
      subjects: {
        "0": false,
        "1": false,
        "2": false,
        "3": false
      }
    }
  }

}
