package com.dianping.cat.build;

import java.util.ArrayList;
import java.util.List;

import org.unidal.dal.jdbc.configuration.AbstractJdbcResourceConfigurator;
import org.unidal.lookup.configuration.Component;

final class CatDatabaseConfigurator extends AbstractJdbcResourceConfigurator {
   @Override
   public List<Component> defineComponents() {
      List<Component> all = new ArrayList<Component>();

      all.add(defineJdbcDataSourceComponent("cat", "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.7.43:3306/cat", "dpcom_cat", "password", "<![CDATA[useUnicode=true&autoReconnect=true]]>"));

      defineSimpleTableProviderComponents(all, "cat", com.dianping.cat.home.dal.report._INDEX.getEntityClasses());
      defineDaoComponents(all, com.dianping.cat.home.dal.report._INDEX.getDaoClasses());

      defineSimpleTableProviderComponents(all, "cat", com.dianping.cat.home.dal.alarm._INDEX.getEntityClasses());
      defineDaoComponents(all, com.dianping.cat.home.dal.alarm._INDEX.getDaoClasses());

      defineSimpleTableProviderComponents(all, "cat", com.dianping.cat.home.dal.abtest._INDEX.getEntityClasses());
      defineDaoComponents(all, com.dianping.cat.home.dal.abtest._INDEX.getDaoClasses());

      return all;
   }
}
