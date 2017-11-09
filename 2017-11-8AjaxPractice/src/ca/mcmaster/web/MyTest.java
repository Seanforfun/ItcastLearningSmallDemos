package ca.mcmaster.web;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.mcmaster.vo.Cities;
import ca.mcmaster.vo.Provinces;

import com.thoughtworks.xstream.XStream;

public class MyTest {

		@Test
		public void test()
		{
			List<Cities> list = new ArrayList<Cities>();
			list.add(new Cities("Toronto"));
			list.add(new Cities("Hamilton"));
			list.add(new Cities("London"));
			list.add(new Cities("Ottawa"));
			list.add(new Cities("Windsor"));
			list.add(new Cities("Waterloo"));
			Provinces p = new Provinces("Ontario", list);
			
			List<Cities> list2 = new ArrayList<>();
			list2.add(new Cities("Vancouver"));
			list2.add(new Cities("Victoria"));
			list2.add(new Cities("Kelowna"));
			list2.add(new Cities("Abbotsford"));
			list2.add(new Cities("Kamloops"));
			list2.add(new Cities("Nanaimo"));
			Provinces p1 = new Provinces("British Columbia", list2);
			List<Provinces> pList = new ArrayList<>();
			pList.add(p);
			pList.add(p1);
			XStream xml = new XStream();
			xml.autodetectAnnotations(true);
			String ret = xml.toXML(pList);
			System.out.println(ret);
		}
}
