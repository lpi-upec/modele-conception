package fr.esipe.mch.strategie;

public abstract class AbstractTaxe {
	protected double taxeValue;
	protected AbstractTaxe nextTaxe;

	public abstract void process(AbstractTaxe taxe);

	public void setNextTaxe(AbstractTaxe taxe) {
		this.nextTaxe = taxe;
	}

	public double getTaxe() {
		return taxeValue;
	}

	public void execute() {
		process(this);
	}

	public static void main(String[] args) {
		CarbonTaxe carbonTaxe = new CarbonTaxe(2);
		HabitationTaxe habitationTaxe = new HabitationTaxe(3);
		CitoyenTaxe citoyenTaxe = new CitoyenTaxe(1000);
		citoyenTaxe.setNextTaxe(carbonTaxe);
		carbonTaxe.setNextTaxe(habitationTaxe);
		citoyenTaxe.execute();
		System.out.println(habitationTaxe.getTaxe());
	}
}
class CitoyenTaxe extends AbstractTaxe {
	private double revenue;

	public CitoyenTaxe(double revenue) {
		this.revenue = revenue;
	}

	@Override
	public void process(AbstractTaxe taxe) {
		if (taxe != null) {
			taxeValue = revenue;
			nextTaxe.process(this);
		}
	}

	public double getRevenue() {
		return revenue;
	}
}
class CarbonTaxe extends AbstractTaxe {

	public CarbonTaxe(double taxeValue) {
		this.taxeValue = taxeValue;
	}

	@Override
	public void process(AbstractTaxe taxe) {
		if (taxe != null) {
			taxeValue = taxe.getTaxe() - taxeValue;
			nextTaxe.process(this);
		}
	}
}
class HabitationTaxe extends AbstractTaxe {

	public HabitationTaxe(double taxeValue) {
		this.taxeValue = taxeValue;
	}

	@Override
	public void process(AbstractTaxe taxe) {
		if (taxe != null) {
			taxeValue = taxe.getTaxe() - taxeValue - 100;
		}
	}
}