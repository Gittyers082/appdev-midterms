package appdev.refactor;

/**
 * "We'll probably need PDF, CSV and Excel exports someday."
 */
public abstract class ReportExporter {

    public abstract void export(String data, String format, boolean compress, int version);

    public abstract void exportAsync(String data, String format, boolean compress, int version);
}
