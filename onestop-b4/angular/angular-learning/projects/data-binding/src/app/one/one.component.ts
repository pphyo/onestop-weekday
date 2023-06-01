import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-one',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterModule],
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css']
})
export class OneComponent {

}
