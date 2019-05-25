import { Injectable } from '@angular/core';
import { LoadingController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class LoadingService {

  load: HTMLIonLoadingElement;

  constructor(private loadCtrl: LoadingController) { }

  async loadingShow() {
    this.load = await this.loadCtrl.create({
      translucent: true,
      message: 'Cargando...'
    });
    this.load.present();
  }

  async loadingHide() {
    if (this.load) {
      await this.load.dismiss();
    }
  }

  async loadingShowWithMessage(msg: string) {
    this.load = await this.loadCtrl.create({
      translucent: true,
      message: msg,
    });
    this.load.present();
  }
}
