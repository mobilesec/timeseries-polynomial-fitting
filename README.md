# timeseries-polynomial-fitting
This time series polynomial fitting is an attempt to provide polynomial fitting as we have in matlab polyfit and polyval

# Usage
public static example (String [] args) { 
  // X axis 
  double [] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
  // Y axis 
  double [] y = {2.3, 2.3, 2.4, 2.8, 2.9, 2.6, 2.9, 3.2, 3.9, 4.0, 4.3, 4.2, 4.2, 4.0, 3.8, 4.0, 3.5, 3.3, 3.2, 2.8}; 
  Polyfit polyfit = null; 
  Polyval polyval; 
  try { 
  // Create polynomial fitting object which is 4 times 4 shows polynomial fitting 
  polyfit = new Polyfit (x, y, 4); 
  polyval = new Polyval (x, polyfit); 
  for (int i = 0; i <= polyval.getYout () length - 1;. i ++) { 
  . BigDecimal bd = new BigDecimal (polyval.getYout () [i]) setScale (2, BigDecimal.ROUND_HALF_UP); 
  System.out.println (i + 1 + "\ t" + bd.toString ()); 
  } 
  } Catch (Exception e) { 
  System.out.println ("Error:" + e.getMessage () + "\ n"); 
  e.printStackTrace (); 
  } 
  } 

