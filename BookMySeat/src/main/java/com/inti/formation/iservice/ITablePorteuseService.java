package com.inti.formation.iservice;

import java.util.List;

import com.inti.formation.entity.TablePorteuseId;
import com.inti.formation.entity.TablePorteuseStation_Line_Vehicle;

public interface ITablePorteuseService {

	public TablePorteuseStation_Line_Vehicle add(TablePorteuseStation_Line_Vehicle tp);

	public TablePorteuseStation_Line_Vehicle update(TablePorteuseStation_Line_Vehicle tp);

	public void delete(TablePorteuseId tpId);

	public TablePorteuseStation_Line_Vehicle getById(TablePorteuseId tpId);

	public List<TablePorteuseStation_Line_Vehicle> findAll();

}
