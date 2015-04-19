# timeseries-polynomial-fitting
This time series polynomial fitting is an attempt to provide polynomial fitting as we have in matlab polyfit and polyval

# Usage
public static main (String [] args) {__ 
  // X axis__ 
  double [] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};__ 
  // Y axis__ 
  double [] y = {2.3, 2.3, 2.4, 2.8, 2.9, 2.6, 2.9, 3.2, 3.9, 4.0, 4.3, 4.2, 4.2, 4.0, 3.8, 4.0, 3.5, 3.3, 3.2, 2.8};__ 
  Polyfit polyfit = null;__ 
  Polyval polyval;__ 
  try {__ 
  // Create polynomial fitting object which is 4 times 4 shows polynomial fitting__ 
  polyfit = new Polyfit (x, y, 4);__ 
  polyval = new Polyval (x, polyfit);__ 
  for (int i = 0; i <= polyval.getYout () length - 1;. i ++) {__ 
  . BigDecimal bd = new BigDecimal (polyval.getYout () [i]) setScale (2, BigDecimal.ROUND_HALF_UP);__ 
  System.out.println (i + 1 + "\ t" + bd.toString ());__ 
  }__ 
  } Catch (Exception e) {__ 
  System.out.println ("Error:" + e.getMessage () + "\ n");__ 
  e.printStackTrace ();__ 
  }__ 
  }__ 

