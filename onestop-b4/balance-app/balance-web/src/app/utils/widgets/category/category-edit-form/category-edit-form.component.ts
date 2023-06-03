import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { categoryType } from 'src/app/services/data';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CategoryService } from 'src/app/services/categories.service';

@Component({
  selector: 'app-category-edit-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './category-edit-form.component.html'
})
export class CategoryEditFormComponent implements OnInit {

  form:FormGroup

  catType = categoryType

  constructor(public builder:FormBuilder,
    private service:CategoryService,
    private route:ActivatedRoute,
    private router:Router) {

    this.form = this.builder.group({
      id: 0,
      name: ['', Validators.required],
      type: ['', Validators.required],
      icon: ''
    })
  }

  ngOnInit():void {
    let id:number = 0

    this.route.queryParamMap.subscribe(param => {
      id = + (param.get('id') as string)
    })

    this.service.findById(id).subscribe(result => {
      this.form = this.builder.group({
        id: result.id,
        name: [result.name, Validators.required],
        type: [result.type, Validators.required],
        icon: result.icon
      })
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
