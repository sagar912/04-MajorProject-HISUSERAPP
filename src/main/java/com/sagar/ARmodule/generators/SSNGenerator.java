package com.sagar.ARmodule.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SSNGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "AR100";
		String suffix = "";
		Connection con = null;
		try {
			con = session.connection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT APPLICANTS_ID_SEQ.NEXTVAL FROM DUAL");

			if (rs.next()) {
				int seqval = rs.getInt(1);
				suffix = String.valueOf(seqval);			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix + suffix;
	}

}
