import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { categoryType } from 'src/app/services/data';
import { RouterModule } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { PageTitleComponent } from '../../page-title/page-title.component';

@Component({
  selector: 'app-category-search-form',
  standalone: true,
  imports: [CommonModule, RouterModule, ReactiveFormsModule, PageTitleComponent],
  templateUrl: './category-search-form.component.html'
})
export class CategorySearchFormComponent {

  catType = categoryType
  form:FormGroup

  @Output()
  onSearch = new EventEmitter<any>

  @Output()
  onUpload = new EventEmitter<any>

  constructor(public builder:FormBuilder) {
    this.form = this.builder.group({
      name: '',
      type: ''
    })
  }

  search() {
    this.onSearch.emit(this.form.value)
  }

  upload(file:FileList) {
    if(file.length > 0) {
      this.onUpload.emit(file[0])
    }
  }

}
