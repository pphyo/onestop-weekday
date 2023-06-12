import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfirmComponent } from '../../confirm/confirm.component';

declare var bootstrap:any

@Component({
  selector: 'app-balance-detail',
  standalone: true,
  imports: [CommonModule, ConfirmComponent],
  templateUrl: './balance-detail.component.html'
})
export class BalanceDetailComponent implements OnInit {

  @Input()
  data:any

  confirmModal:any
  removeId:any

  @Output()
  onRemove = new EventEmitter<number>

  @Output()
  onEdit = new EventEmitter<any>

  ngOnInit(): void {
    this.confirmModal = new bootstrap.Modal('#confirm',
      {backdrop: false})
  }

  remove(id:number) {
    this.confirmModal.show()
    this.removeId = id
  }

  confirmRemove(id:any) {
    if(id)
      this.onRemove.emit(id)

    this.confirmModal.hide()
  }

  edit() {
    this.onEdit.emit(true)
  }

}
