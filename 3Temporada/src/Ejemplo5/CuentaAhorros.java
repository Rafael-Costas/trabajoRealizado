package Ejemplo5;

public class CuentaAhorros extends Cuenta{

	private boolean activo;
	public CuentaAhorros(float saldo, float TasaAnual) {
		super(saldo, TasaAnual);
		if(this.saldo>10000) {
			this.activo=true;
		}else {
			this.activo=false;
		}
	}
	
	@Override
	public void consignar(float cantidad) {
		if(activo)
		super.consignar(cantidad);
	}
	@Override
	public void retirar(float cantidad) {
		if(activo)
		super.retirar(cantidad);
	}
	
	@Override
	public void CalcularInteres() {
		if(this.activo) {
		if(this.NumeroRetiro>4) {
			this.ComisionMensual+=1000*(NumeroRetiro-4);
			super.CalcularInteres();
		}else
			super.CalcularInteres();
		}else {
			System.out.println("La cuenta no está activa");
		}
		}

	
	@Override
	public String toString() {
		return "CuentaAhorros [activo=" + activo + ", saldo=" + saldo + ", NumConsignaciones=" + NumConsignaciones
				 + NumeroRetiro + ", ComisionMensual=" + ComisionMensual + "]";
	}

	
	
}
