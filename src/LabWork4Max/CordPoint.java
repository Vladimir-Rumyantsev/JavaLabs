package LabWork4Max;

public class CordPoint {

    private float X;
    private float Y;
    private float Z;
    private boolean dim3;

    public CordPoint(float X, float Y, float Z) {
        setX(X);
        setY(Y);
        setZ(Z);
        setdim3(true);
    }

    public float[] getPoint() {
        if (dim3 == true) {
            float[] Coord = new float[3];
            Coord[0] = getX();
            Coord[1] = getY();
            Coord[2] = getZ();
            return Coord;
        }
        else if (dim3 == false) {
            float[] Coord = new float[2];
            Coord[0] = getX();
            Coord[1] = getY();
            return Coord;
        }
        else {
            return new float[0];
        }
    }

    public void setX(float X) {
        this.X = X;
    }

    public void setY(float Y) {
        this.Y = Y;
    }

    public void setZ(float Z) {
        this.Z = Z;
    }

    public void setdim3(boolean dim) {
        this.dim3 = dim;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public float getZ() {
        return Z;
    }

    public boolean getdim3 () {
        return dim3;
    }

    public String toString() {
        if (dim3 == false) {
            return String.format("{%+,010.2f%n;%+,010.2f%n}", X, Y);
        }
        else if (dim3 == true) {
            return String.format("{%+,010.2f%n;%+,010.2f%n;%+,010.2f%n}", X, Y, Z);
        }
        return "";
    }
}