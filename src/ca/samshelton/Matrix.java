package ca.samshelton;

public class Matrix
{
	private double[] matrix;
	private int r;            // Rows
	private int c;            // Cols
	/*
	 * Construct an m/n matrix.
	 */
	public Matrix(int r,int c)
	{
		this.r = r;
		this.c = c;
		matrix = new double[r*c];
	}
	/*
	 * Construct a square matrix.
	 */
	public Matrix(int c)
	{
		this.r = c;
		this.c = c;
		matrix = new double[c*c];

	}
	/*
	 * Construct a matrix in R1
	 * using a 1D array.
	 */
	public Matrix(double[] arr)
	{
		this.r = arr.length;
		this.c = 1;
		matrix = new double[r];
	}
	/*
	 * Construct a matrix using
	 * a 2D array.
	 */
	public Matrix(double[][] arr)
	{
		this.r = arr[0].length;
		this.c = arr.length;
		matrix = new double[r*c];
	}
	
	/**
	 * MANIPULATORS
	 */
	// Single Element
	public double getElement(int m, int n)
	{
		return matrix[c*(m-1)+n];
	}
	
	public void setElement(int m, int n, double val)
	{
		matrix[c*(m-1)+n] = val;
	}
	
	// Series
	public double[] getRow(int m)
	{
		double[] row = new double[c];
		for(int i=0; i<c; i++)
			row[i] = matrix[c*(m-1)+1+i];
		return row;
	}
	public void setRow(int m, double[] row)
	{
		for(int i=0; i<c; i++)
			matrix[c*(m-1)+1+i] = row[i];
	}
	
	public double[] getColumn(int n)
	{
		double[] col = new double[r];
		for(int i=0; i<r; i++)
			col[i] = matrix[n+(r*i)];
		return col;
	}
	public void setColumn(int n, double[] col)
	{
		for(int i=0; i<r; i++)
			matrix[n+(r*i)] = col[i];
	}
	public void copyElement(int m1, int n1, int m2, int n2)
	{
		setElement(m2,n2,getElement(m1,n1));
	}
	
	/**
	 * ElEMENTARY OPERATIONs
	 */
	public void add(Matrix mat)
	{
		for(int i=0; i<r*c; i++)
			matrix[i] += mat.getMatrix()[i];
	}
	public void subtract(Matrix mat)
	{
		for(int i=0; i<r*c; i++)
			matrix[i] -= mat.getMatrix()[i];
	}
	
	public void multiply(Matrix mat)
	{
		c = mat.getColumns();
		double[] newMatrix = new double[r*c];
		for(int i=0; i<r; i++)
		{
			for(int k=0; k<c; k++)
			{
				newMatrix[(i+1)*(k+1)] = getRow(i+1)[k+1]*mat.getColumn(i+1)[k+1];
			}
		}
		matrix = newMatrix;
	}
	
	
	
	
	/*  
	 *  OPERATIONS
	 *  +  addition 
		+  subtraction 
		   multiplication 
		   scalar multiplication 
		   element-wise multiplication 
		   element-wise division 
		   unary minus 
		   transpose 
		   norm
		
		DECOMP / FACTORIZATION
		   Cholesky 
		   LU 
		   QR 
		   SVD 
		   symmetric eigenvalue 
		   nonsymmetric eigenvalue
		
		SOLUTIONS
		   nonsingular systems 
		   least squares
		
		DERIVITAVES
		   condition number 
		   determinant 
		   rank 
		   inverse 
		   pseudoinverse
	 */
	
	/**
	 * GETTERS
	 */
	public double[] getMatrix()
	{
		return matrix;
	}
	public int getRows()
	{
		return r;
	}
	public int getColumns()
	{
		return c;
	}
	
	public static void main(String[] args)
	{
		double[] m1r1 = {1,2,3};
		double[] m1r2 = {4,5,6};
		Matrix m1 = new Matrix(2,3);
		m1.setRow(1, m1r1);
		m1.setRow(2, m1r2);
		
		double[] m2r1 = {7,8};
		double[] m2r2 = {9,10};
		double[] m2r3 = {11,12};
		Matrix m2 = new Matrix(3,2);
		m2.setRow(1, m2r1);
		m2.setRow(2, m2r2);
		m2.setRow(3, m2r3);
		
		m1.multiply(m2);
		
		System.out.println(m1.getRow(1));
		System.out.println(m1.getRow(2));
	}
}









