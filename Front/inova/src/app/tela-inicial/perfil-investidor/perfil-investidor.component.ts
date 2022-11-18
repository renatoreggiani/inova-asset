import {Component} from '@angular/core';
import {ApiBackendService} from "../services/api-backend.service";
import {BehaviorSubject} from "rxjs";
import {Fundo} from "../models/Fundo";

@Component({
  selector: 'app-perfil-investidor',
  templateUrl: './perfil-investidor.component.html',
  styleUrls: ['./perfil-investidor.component.scss']
})

export class PerfilInvestidorComponent {

  exibirBotaoPerfis = true;
  response: Fundo[] = [];
  perfilSelecionado = -1;

  PERFIS_INVESTIDOR = [
    {id: 0, label: 'Conservador', color:'blue'},
    {id: 1, label: 'Moderado', color:'grey'},
    {id: 2, label: 'Arrojado', color:'red'}
  ];

  constructor(private api: ApiBackendService) {

  }

  onClickPerfil(perfil: any) {
    this.api.getBuscarFundosPorPerfil(perfil).subscribe((response: Fundo[]) => {
      if (response.length > 0) {
        this.response = response;
        this.exibirBotaoPerfis = false;
        this.perfilSelecionado = perfil;
      } else {
        alert('Não foram encontrados fundo para o perfil selecionado!')
      }

    });

  }

  onClickVoltar(): void {
    this.exibirBotaoPerfis = true;
    this.response = [];
    this.perfilSelecionado = -1;
  }

  identificarPerfilSelecionado(): string {
    const perf = this.PERFIS_INVESTIDOR.find(p => p.id === this.perfilSelecionado);
    return perf ? perf.label : '';
  }

  identificarCor() {
    return 'color:' + this.PERFIS_INVESTIDOR[this.perfilSelecionado].color;
  }
}
