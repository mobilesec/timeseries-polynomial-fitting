package jamlab;

/**
 * Title:        Java Matrix Laboratory<p>
 * Description:  <p>
 * Copyright:    Copyright (c) 2000<p>
 * @author Sione .K. Palu
 * @version 1.0
 */


import Jama.*;
import Jama.util.*;
import jamlab.*;
public class Polyfit
{
  private Matrix R;
  private double[] polynomialCoefficients ;
  private int degreeOfFreedom;
  private double norm;
  private double yIntercept ;
  private Matrix polyCoeffMatrix ;


  public Polyfit(double[] _x , double[] _y , int order) throws Exception{
    int xLength = _x.length,
        yLength = _y.length;
    double tempValue = 0.0;
    Matrix y2D = new Matrix(JElmat.convertTo2D(_y));
    Matrix yTranspose = y2D.transpose();

    if(xLength != yLength){
	throw new Exception(" Polyfit :- The lengths of the 2-input array parameters must be equal.");
	}
    if(xLength < 2){
	throw new Exception(" Polyfit :- There must be at least 2 data points for polynomial fitting.");
	}
    if(order < 0){
	throw new Exception(" Polyfit :- The polynomial fitting order cannot be less than zero.");
	}
    if(order >= xLength){
	 throw new Exception(" Polyfit :- The polynomial order = "+order+" , must be less than the number of data points = "+xLength);
	}
    Matrix tempMatrix = null;
    try{
	  tempMatrix = JElmat.vander(_x,order+1);
	 }
    catch(Exception ex){
	ex.printStackTrace();
    }

    QRDecomposition qr = new QRDecomposition(tempMatrix);
    Matrix Q = qr.getQ();
    R = qr.getR();
    Matrix result = R.inverse().times(Q.transpose().times(yTranspose));
    double[][] arrayResult = result.transpose().getArray();
    polynomialCoefficients = arrayResult[0];
    degreeOfFreedom = yLength - (order+1);
    Matrix r = yTranspose.minus(tempMatrix.times(result));
    norm = r.norm2();
    polyCoeffMatrix = new Matrix(JElmat.convertTo2D(polynomialCoefficients));
    yIntercept = polynomialCoefficients[polynomialCoefficients.length-1];

  }//end constructor


  public double[] getPolynomialCoefficients(){
     return polynomialCoefficients ;
    }

  public Matrix getR(){
     return R;
    }

  public int getDegreeOfFreedom(){
     return degreeOfFreedom;
    }

  public double getNorm(){
     return norm;
    }

  public double getYIntercept(){
    return yIntercept;
    }

  public Matrix getPolyCoeffMatrix(){
    return polyCoeffMatrix ;
    }

  /*
  public static void main(String[] args){
    //double[] x = {1,2,3,4,5,6};
    //double[] y = {1.2,1.8,2.8,4.3,4.9,6.2};
    double[] x = {3.2,2.7,1.,4.8,5.6};
    double[] y = {22.0,17.8,14.2,38.3,51.7};
    Polyfit polyfit ;

    double[][] qrD = {
			    {1.,0.,0.},
			    {1.,1.,0.},
			    {1.,1.,1.},
			    {1.,1.,1.}
			   };
    Matrix qrdecom = new Matrix(qrD);
    //qrdecom.print(6,4);
    QRDecomposition newQR = new QRDecomposition(qrdecom);
     //System.out.println("----------------Q-------------------\n");
    //newQR.getQ().print(6,4);
    //System.out.println("----------------R-------------------\n");
    //newQR.getR().print(6,4);
    //System.out.println("----------------Q*R-------------------");
    //newQR.getQ().times(newQR.getR()).print(6,4);

    //--------------------------------------------
    double[][] K = {
	              {1,2,3,4,5,6},
			  {7,8,9,10,11,12},
			  {13,14,15,16,17,18}
	              };
    Matrix matK = new Matrix(K);
    //System.out.println("------------Matrix K---------------------");
    //matK.print(6,0);
    double[][] KcolPack = new double[1][];
    KcolPack[0] = matK.getColumnPackedCopy();
    Matrix matColPack = new Matrix(KcolPack);
    //System.out.println("------------Matrix ColumnPack------------");
    //matColPack.transpose().print(6,0);
    double[][] KrowPack = new double[1][];
    KrowPack[0] = matK.getRowPackedCopy();
    Matrix matRowPack = new Matrix(KrowPack);
    //System.out.println("------------Matrix RowPack------------");
    //matRowPack.print(6,0);
    //--------------------------------------------
    try{
	polyfit = new Polyfit(x,y,3);
	System.out.println("Norm = "+polyfit.getNorm());
	}
	catch(Exception e)
	  {
	    System.out.println("Error : "+e.getMessage()+"\n");
	    e.printStackTrace();
	    }
  }
  */

}//---------------------------- End Class Definition ------------------------------