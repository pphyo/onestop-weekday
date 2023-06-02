import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { categoryType } from 'src/app/services/data';
import { Router, RouterModule } from '@angular/router';
import { CategoryService } from 'src/app/services/categories.service';

@Component({
  selector: 'app-category-edit-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './category-edit-form.component.html'
})
export class CategoryEditFormComponent {

  form:FormGroup

  catType = categoryType

  constructor(public builder:FormBuilder,
    private service:CategoryService,
    private router:Router) {
    this.form = this.builder.group({
      id: 0,
      name: ['', Validators.required],
      type: ['', Validators.required],
      icon: ''
    })
  }

  save() {
    if(this.form.valid) {
      this.service.save(this.form.value).subscribe(param => {
        this.router.navigate(['/categories'])
      })
    }
  }

}
