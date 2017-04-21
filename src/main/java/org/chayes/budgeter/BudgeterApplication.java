package org.chayes.budgeter;

import com.palantir.config.crypto.EncryptedConfigValueBundle;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import org.chayes.budgeter.db.*;
import org.chayes.budgeter.resources.UsersResource;

public class BudgeterApplication extends Application<BudgeterConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BudgeterApplication().run(args);
    }

    @Override
    public String getName() {
        return "Budgeter";
    }

    @Override
    public void initialize(final Bootstrap<BudgeterConfiguration> bootstrap) {
        bootstrap.addBundle(new EncryptedConfigValueBundle());
    }

    @Override
    public void run(final BudgeterConfiguration configuration,
                    final Environment environment) {
        final io.dropwizard.jdbi.DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final UserDao dao = jdbi.onDemand(UserDao.class);
        environment.jersey().register(new UsersResource(dao));
    }

}
