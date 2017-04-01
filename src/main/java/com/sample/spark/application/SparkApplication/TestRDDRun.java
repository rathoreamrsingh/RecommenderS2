package com.sample.spark.application.SparkApplication;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.ml.recommendation.ALS.Rating;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class TestRDDRun {

	public static void main(String[] args) {
		SparkSession sc = SparkSession.builder().appName("Test Spark App ").master("local[4]").getOrCreate();

		Dataset<String> users = sc.read().textFile("/Users/amar/Downloads/challenge_2/users.psv");
		Dataset<String> ratings = sc.read().textFile("/Users/amar/Downloads/challenge_2/ratings.psv");
		Dataset<String> visits = sc.read().textFile("/Users/amar/Downloads/challenge_2/visits.psv");
		Dataset<String> venues = sc.read().textFile("/Users/amar/Downloads/challenge_2/venues.psv");
		Dataset<String> socialGraph = sc.read().textFile("/Users/amar/Downloads/challenge_2/socialgraph.psv");

		JavaRDD<UserData> usersRDD = users.javaRDD().map(new Function<String, UserData>() {
			public UserData call(String str) {
				return UserData.parseData(str);
			}
		});

		JavaRDD<RatingsData> ratingsRDD = ratings.javaRDD().map(new Function<String, RatingsData>() {
			public RatingsData call(String str) {
				return RatingsData.parseData(str);
			}
		});

		JavaRDD<Visits> visitsRDD = visits.javaRDD().map(new Function<String, Visits>() {
			public Visits call(String str) {
				return Visits.parseData(str);
			}
		});

		JavaRDD<Venues> venuesRDD = venues.javaRDD().map(new Function<String, Venues>() {
			public Venues call(String str) {
				return Venues.parseData(str);
			}
		});

		JavaRDD<SocialGraph> socialGraphRDD = socialGraph.javaRDD().map(new Function<String, SocialGraph>() {
			public SocialGraph call(String str) {
				return SocialGraph.parseData(str);
			}
		});

		Dataset<Row> ratingsDataSet = sc.createDataFrame(ratingsRDD, RatingsData.class);
		Dataset<Row>[] splits = ratingsDataSet.randomSplit(new double[] { 0.8, 0.2 }, 19);

		// System.out.println(ratings.fla);
	}

}