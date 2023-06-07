import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryService } from 'src/app/services/categories.service';
import { CategoryListComponent } from 'src/app/utils/widgets/category/category-list/category-list.component';
import { CategorySearchFormComponent } from 'src/app/utils/widgets/category/category-search-form/category-search-form.component';
import { CategoryEditFormComponent } from 'src/app/utils/widgets/category/category-edit-form/category-edit-form.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories',
  standalone: true,
  imports: [CommonModule, CategorySearchFormComponent, CategoryListComponent, CategoryEditFormComponent],
  templateUrl: './categories.component.html'
})
export class CategoriesComponent implements OnInit {

  categories:any[] = []

  constructor(private service:CategoryService, private router:Router) {}

  ngOnInit(): void {
    this.search(null)
  }

  search(params:any) {
    this.service.find(params).subscribe(result => this.categories = result)
  }

  remove(id:number) {
    this.service.remove(id).subscribe(result => {
      this.search(null)
    })
  }

  upload(file:any) {
    if(file)
      this.service.upload(file).subscribe(result => this.categories = result)
  }
}
