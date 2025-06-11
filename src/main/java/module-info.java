module com.oficinaeahb.countgest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.oficinaeahb.countgest to javafx.fxml;
    exports com.oficinaeahb.countgest;
    requires org.apache.commons.text;
    requires com.jfoenix;
    requires eu.iamgio.animated;
}
