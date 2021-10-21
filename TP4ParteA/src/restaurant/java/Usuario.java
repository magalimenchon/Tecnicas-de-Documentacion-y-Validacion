package restaurant.java;
import java.util.Date;

public class Usuario {
static int nextID;
int id;
String nombreYApellido;
int tipoUsuario;
float saldoCuenta;
Date ultimaRecarga;
String email;
public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
	super();
	this.nombreYApellido = nombreYApellido;
	this.tipoUsuario = tipoUsuario;
	this.saldoCuenta = saldoCuenta;
	this.email=email;
}

public void cargarCredito(float cuanto) {
	saldoCuenta+=cuanto;
	
}
float descontarSaldo(float cuanto) throws SinSaldoException {
	if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
	else
		saldoCuenta-= cuanto;
	return saldoCuenta;
	
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public float getSaldo() {
	return saldoCuenta;
}

@Override
public String toString() {
	return this.nombreYApellido + this.email;
}

@Override
public boolean equals(Object o) {
	try {
		if(this.toString().equals(o.toString())) {
			return true;
		}else
			return false;
	}catch(Exception e){
		return false;
	}
}
}
