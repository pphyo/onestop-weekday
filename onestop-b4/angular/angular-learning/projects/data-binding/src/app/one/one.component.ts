import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-one',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css']
})
export class OneComponent {

}
