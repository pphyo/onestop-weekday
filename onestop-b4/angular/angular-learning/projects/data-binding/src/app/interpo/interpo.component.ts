import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-interpo',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './interpo.component.html',
  styleUrls: ['./interpo.component.css']
})
export class InterpoComponent {

  value:any

  add(value:any) {
    this.value = value
  }

}
