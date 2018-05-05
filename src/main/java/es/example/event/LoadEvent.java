package es.example.event;

import java.util.Arrays;
import java.util.List;

import es.example.model.Cargo;
import es.example.model.Ship;

/**
 * @author Juan
 */
public class LoadEvent implements DomainEvent { 

    private List<Cargo> cargos;

    public LoadEvent(Cargo ...cargos) {
        this.cargos = Arrays.asList(cargos);
    }

	@Override
	public void process(Ship ship) {
        this.cargos.stream().forEach((c) -> c.setShipId(ship.getId()));
		ship.setCargos(this.cargos);
	}
}