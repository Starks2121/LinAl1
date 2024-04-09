package Math;

public class Vector4f {
    private static final float eps = 1e-7f;
    private float x, y, z, k;

    public Vector4f() {

    }

    public Vector4f(float x, float y, float z, float k) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.k = k;
    }

    public Vector4f addition(Vector4f first, Vector4f second) {
        float x = first.x + second.x;
        float y = first.y + second.y;
        float z = first.z + second.z;
        float k = first.k + second.k;
        return new Vector4f(x, y, z, k);
    }

    public Vector4f subtraction(Vector4f first, Vector4f second) {
        float x = first.x - second.x;
        float y = first.y - second.y;
        float z = first.z - second.z;
        float k = first.k - second.k;
        return new Vector4f(x, y, z, k);
    }

    public Vector4f multiplicationByScalar(Vector4f vector, float scalar) {
        float x = vector.x * scalar;
        float y = vector.y * scalar;
        float z = vector.z * scalar;
        float k = vector.k * scalar;
        return new Vector4f(x, y, z, k);
    }

    public Vector4f divisionByScalar(Vector4f vector, float scalar) {
        if (scalar == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя");
        }
        float x = vector.x / scalar;
        float y = vector.y / scalar;
        float z = vector.z / scalar;
        float k = vector.k / scalar;
        return new Vector4f(x, y, z, k);
    }

    public float vectorLength(Vector4f vector) {
        return (float) Math.sqrt(Math.pow(vector.x, 2) + Math.pow(vector.y, 2) + Math.pow(vector.z, 2) + Math.pow(vector.k, 2));
    }

    public Vector4f normalize(Vector4f vector) {
        float length = vectorLength(vector);
        float invLength = 1 / length;
        float x = vector.x * invLength;
        float y = vector.y * invLength;
        float z = vector.z * invLength;
        float k = vector.k * invLength;
        return new Vector4f(x, y, z, k);
    }

    public float scalarProduct(Vector4f first, Vector4f second) {
        return (first.x * second.x) + (first.y * second.y) + (first.z * second.z) + (first.k * second.k);
    }

    public String toString() {
        return "Вектор (" + x + " , " + y + " , " + z + " , " + k + ")";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Vector4f other)) {
            return false;
        }
        return Math.abs(x - other.x) < eps && Math.abs(y - other.y) < eps && Math.abs(z - other.z) < eps&& Math.abs(k - other.k) < eps;
    }
}
