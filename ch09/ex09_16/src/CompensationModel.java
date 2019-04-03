class CompensationModel {
	// this is meant to be overridden by the subclasses
	public double earnings() {
		return 0.0; // this should never execute
	}
	
	@Override
	public String toString() {
		return "This method is ment to be overridden";
	}
}

class CommissionCompansationModel extends CompensationModel {
	// instance variables
	private double grossSales;
	private double commissionRate;
	
	public CommissionCompansationModel(double grossSales, double commissionRate) {
		// implicitly calls CompensationModel's default constructor
		
		// if grossSales is invalid throw exception
	    if (grossSales < 0.0) {
	       throw new IllegalArgumentException("Gross sales must be >= 0.0");
	    }      

	    // if commissionRate is invalid throw exception
	    if (commissionRate <= 0.0 || commissionRate >= 1.0) {
	       throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	    }
	    this.grossSales = grossSales;
	    this.commissionRate = commissionRate;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	
	public void setGrossSales(double grossSales) {
		// if grossSales is invalid throw exception
	    if (grossSales < 0.0) {
	       throw new IllegalArgumentException("Gross sales must be >= 0.0");
	    }      
	    this.grossSales = grossSales;
	}
	
	public void setCommissionRate(double commissionRate) {
	    // if commissionRate is invalid throw exception
	    if (commissionRate <= 0.0 || commissionRate >= 1.0) {
	       throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	    }
	    this.commissionRate = commissionRate;
	}
	
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}
	
	@Override
	public String toString() {
		return String.format("Commission compansation model: commission rate : %.2f, gross sales: %.2f%n",
				getCommissionRate(), getGrossSales());
	}
}

class BasePlusCommissionCompensationModel extends CompensationModel {
	// instance variables
	private double grossSales;
	private double commissionRate;
	private double baseSalary;
	
	public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, 
			double baseSalary) {
		// implicitly calls CompensationModel's default constructor
		
		// if grossSales is invalid throw exception
	    if (grossSales < 0.0) {
	       throw new IllegalArgumentException("Gross sales must be >= 0.0");
	    }      

	    // if commissionRate is invalid throw exception
	    if (commissionRate <= 0.0 || commissionRate >= 1.0) {
	       throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	    }
	    
	    // if baseSalary is invalid throw exception
	    if(baseSalary < 0.0) {
	    	throw new IllegalArgumentException("Base salary cannot be less than zero");
	    }
	    this.baseSalary = baseSalary;
	    this.grossSales = grossSales;
	    this.commissionRate = commissionRate;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	
	public void setBaseSalary(double baseSalary) {
	    // if baseSalary is invalid throw exception
	    if(baseSalary < 0.0) {
	    	throw new IllegalArgumentException("Base salary cannot be less than zero");
	    }
	    this.baseSalary = baseSalary;		
	}
	
	public void setGrossSales(double grossSales) {
		// if grossSales is invalid throw exception
	    if (grossSales < 0.0) {
	       throw new IllegalArgumentException("Gross sales must be >= 0.0");
	    }
	    this.grossSales = grossSales;
	}
	
	public void setCommissionRate(double commissionRate) {
	    // if commissionRate is invalid throw exception
	    if (commissionRate <= 0.0 || commissionRate >= 1.0) {
	       throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
	    }
	    this.commissionRate = commissionRate;
	}
	
	@Override
	public double earnings() {
		return getBaseSalary() + (getCommissionRate() * getGrossSales());
	}
	
	@Override
	public String toString() {
		return String.format("Base plus commission compansation model: base salary %.2f, commission rate : %.2f, gross sales: %.2f%n",
				getBaseSalary(), getCommissionRate(), getGrossSales());
	}
}



