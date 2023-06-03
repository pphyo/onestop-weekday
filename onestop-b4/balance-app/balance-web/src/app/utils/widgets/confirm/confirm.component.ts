import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-confirm',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './confirm.component.html'
})
export class ConfirmComponent {

  @Output()
  onConfirm = new EventEmitter<any>

  @Input()
  removeId:any

  confirm() {
    this.onConfirm.emit(this.removeId);
  }

}
