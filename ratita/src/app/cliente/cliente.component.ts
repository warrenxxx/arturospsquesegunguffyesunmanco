import {Component, OnInit} from '@angular/core';
import {ClienteService} from './cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  constructor(private clienteService:ClienteService) {
  }

  ngOnInit() {
  }

  insertar() {
    var cliente = {
        id: document.getElementById('id')["value"],
        nombre:document.getElementById('id')["value"],
        ususuario:document.getElementById('id')["value"],
        contraseña:document.getElementById('id')["value"]
    }
    ;
    this.clienteService.insertar(cliente).subscribe(then=>{
      alert("chovi");
    },error=>{
      alert("gg ps guffy")
    }) ;
  }

}
