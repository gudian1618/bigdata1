/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.gudian1618.bigdata1.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Student extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2048105194664801206L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Student\",\"namespace\":\"com.github.gudian1618.bigdata1.avro\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"gender\",\"type\":\"string\"},{\"name\":\"height\",\"type\":\"double\"},{\"name\":\"weight\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Student> ENCODER =
      new BinaryMessageEncoder<Student>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Student> DECODER =
      new BinaryMessageDecoder<Student>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Student> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Student> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Student>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Student to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Student from a ByteBuffer. */
  public static Student fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence name;
  @Deprecated public int age;
  @Deprecated public java.lang.CharSequence gender;
  @Deprecated public double height;
  @Deprecated public double weight;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Student() {}

  /**
   * All-args constructor.
   * @param name The new value for name
   * @param age The new value for age
   * @param gender The new value for gender
   * @param height The new value for height
   * @param weight The new value for weight
   */
  public Student(java.lang.CharSequence name, java.lang.Integer age, java.lang.CharSequence gender, java.lang.Double height, java.lang.Double weight) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return name;
    case 1: return age;
    case 2: return gender;
    case 3: return height;
    case 4: return weight;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: name = (java.lang.CharSequence)value$; break;
    case 1: age = (java.lang.Integer)value$; break;
    case 2: gender = (java.lang.CharSequence)value$; break;
    case 3: height = (java.lang.Double)value$; break;
    case 4: weight = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public java.lang.Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'gender' field.
   * @return The value of the 'gender' field.
   */
  public java.lang.CharSequence getGender() {
    return gender;
  }

  /**
   * Sets the value of the 'gender' field.
   * @param value the value to set.
   */
  public void setGender(java.lang.CharSequence value) {
    this.gender = value;
  }

  /**
   * Gets the value of the 'height' field.
   * @return The value of the 'height' field.
   */
  public java.lang.Double getHeight() {
    return height;
  }

  /**
   * Sets the value of the 'height' field.
   * @param value the value to set.
   */
  public void setHeight(java.lang.Double value) {
    this.height = value;
  }

  /**
   * Gets the value of the 'weight' field.
   * @return The value of the 'weight' field.
   */
  public java.lang.Double getWeight() {
    return weight;
  }

  /**
   * Sets the value of the 'weight' field.
   * @param value the value to set.
   */
  public void setWeight(java.lang.Double value) {
    this.weight = value;
  }

  /**
   * Creates a new Student RecordBuilder.
   * @return A new Student RecordBuilder
   */
  public static com.github.gudian1618.bigdata1.avro.Student.Builder newBuilder() {
    return new com.github.gudian1618.bigdata1.avro.Student.Builder();
  }

  /**
   * Creates a new Student RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Student RecordBuilder
   */
  public static com.github.gudian1618.bigdata1.avro.Student.Builder newBuilder(com.github.gudian1618.bigdata1.avro.Student.Builder other) {
    return new com.github.gudian1618.bigdata1.avro.Student.Builder(other);
  }

  /**
   * Creates a new Student RecordBuilder by copying an existing Student instance.
   * @param other The existing instance to copy.
   * @return A new Student RecordBuilder
   */
  public static com.github.gudian1618.bigdata1.avro.Student.Builder newBuilder(com.github.gudian1618.bigdata1.avro.Student other) {
    return new com.github.gudian1618.bigdata1.avro.Student.Builder(other);
  }

  /**
   * RecordBuilder for Student instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Student>
    implements org.apache.avro.data.RecordBuilder<Student> {

    private java.lang.CharSequence name;
    private int age;
    private java.lang.CharSequence gender;
    private double height;
    private double weight;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.gudian1618.bigdata1.avro.Student.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gender)) {
        this.gender = data().deepCopy(fields()[2].schema(), other.gender);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.height)) {
        this.height = data().deepCopy(fields()[3].schema(), other.height);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.weight)) {
        this.weight = data().deepCopy(fields()[4].schema(), other.weight);
        fieldSetFlags()[4] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Student instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.gudian1618.bigdata1.avro.Student other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.name)) {
        this.name = data().deepCopy(fields()[0].schema(), other.name);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.age)) {
        this.age = data().deepCopy(fields()[1].schema(), other.age);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.gender)) {
        this.gender = data().deepCopy(fields()[2].schema(), other.gender);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.height)) {
        this.height = data().deepCopy(fields()[3].schema(), other.height);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.weight)) {
        this.weight = data().deepCopy(fields()[4].schema(), other.weight);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder setName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.name = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder clearName() {
      name = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public java.lang.Integer getAge() {
      return age;
    }

    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder setAge(int value) {
      validate(fields()[1], value);
      this.age = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder clearAge() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'gender' field.
      * @return The value.
      */
    public java.lang.CharSequence getGender() {
      return gender;
    }

    /**
      * Sets the value of the 'gender' field.
      * @param value The value of 'gender'.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder setGender(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.gender = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'gender' field has been set.
      * @return True if the 'gender' field has been set, false otherwise.
      */
    public boolean hasGender() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'gender' field.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder clearGender() {
      gender = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'height' field.
      * @return The value.
      */
    public java.lang.Double getHeight() {
      return height;
    }

    /**
      * Sets the value of the 'height' field.
      * @param value The value of 'height'.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder setHeight(double value) {
      validate(fields()[3], value);
      this.height = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'height' field has been set.
      * @return True if the 'height' field has been set, false otherwise.
      */
    public boolean hasHeight() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'height' field.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder clearHeight() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'weight' field.
      * @return The value.
      */
    public java.lang.Double getWeight() {
      return weight;
    }

    /**
      * Sets the value of the 'weight' field.
      * @param value The value of 'weight'.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder setWeight(double value) {
      validate(fields()[4], value);
      this.weight = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'weight' field has been set.
      * @return True if the 'weight' field has been set, false otherwise.
      */
    public boolean hasWeight() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'weight' field.
      * @return This builder.
      */
    public com.github.gudian1618.bigdata1.avro.Student.Builder clearWeight() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Student build() {
      try {
        Student record = new Student();
        record.name = fieldSetFlags()[0] ? this.name : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.age = fieldSetFlags()[1] ? this.age : (java.lang.Integer) defaultValue(fields()[1]);
        record.gender = fieldSetFlags()[2] ? this.gender : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.height = fieldSetFlags()[3] ? this.height : (java.lang.Double) defaultValue(fields()[3]);
        record.weight = fieldSetFlags()[4] ? this.weight : (java.lang.Double) defaultValue(fields()[4]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Student>
    WRITER$ = (org.apache.avro.io.DatumWriter<Student>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Student>
    READER$ = (org.apache.avro.io.DatumReader<Student>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
