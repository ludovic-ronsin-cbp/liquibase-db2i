package liquibase.ext.db2i.database;

import java.sql.ResultSet;
import java.sql.Statement;

import liquibase.database.DatabaseConnection;
import liquibase.database.core.AbstractDb2Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.statement.SqlStatement;
import liquibase.statement.core.RawCallStatement;
import liquibase.util.JdbcUtils;
import liquibase.util.StringUtils;

public class DB2iDatabase extends AbstractDb2Database {

    @Override
    public int getPriority() {
        return super.getPriority()+5;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
        return conn.getDatabaseProductName().startsWith("DB2 UDB for AS/400");
    }

    @Override
    public String getDefaultDriver(String url) {
        if (url.startsWith("jdbc:as400")) {
            return "com.ibm.as400.access.AS400JDBCDriver";
        }
        return null;
    }

    @Override
    protected String getDefaultDatabaseProductName() {
        return "DB2i";
    }

    @Override
    public String getShortName() {
        return "db2i";
    }

    @Override
    public boolean supportsSchemas() {
        return true;
    }

    @Override
    public String getDefaultCatalogName() {
//        try {
//            if(this.defaultCatalogName != null){
//                return this.defaultCatalogName;
//            }
//            String catalog = this.getConnection().getCatalog();
//            if(catalog != null) {
//                this.defaultCatalogName = catalog;
//                return defaultCatalogName;
//            }
//        } catch (DatabaseException e) {
//        }
        return super.getDefaultCatalogName();
    }

}
