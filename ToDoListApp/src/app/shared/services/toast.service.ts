import { Injectable } from '@angular/core';
import { ToastController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class ToastService {

  constructor(private toastCtrl: ToastController) { }

  async toastErrorShowWithMessage(msg: string) {
    const load = await this.toastCtrl.create({
      position: 'top',
      translucent: true,
      showCloseButton: true,
      message: msg,
      duration: 3000
    });
    load.present();
  }

  async toastSuccessShowWithMessage(msg: string) {
    const load = await this.toastCtrl.create({
      position: 'top',
      message: msg,
      duration: 2000
    });
    load.present();
  }

  async toastErrorShow() {
    const load = await this.toastCtrl.create({
      position: 'top',
      translucent: true,
      showCloseButton: true,
      color: 'red',
      message: 'Algo ha fallado, intente nuevamente'
    });
    load.present();
  }

}
