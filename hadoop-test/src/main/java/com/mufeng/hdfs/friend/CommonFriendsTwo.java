package com.mufeng.hdfs.friend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class CommonFriendsTwo {
	
	public static class CommonFriendsTwoMapper extends Mapper<LongWritable, Text, Text, Text>{
		Text k = new Text();
		Text v = new Text();
		
		//B-D A
		//B-D C
		//输出：B-D A,C
		
		
		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] userAndFriends = value.toString().split("\t");
			String user = userAndFriends[0];
			k.set(user);
			v.set(userAndFriends[1]);
			context.write(k, v);

			
		}
		
		
		
	}
	
	
	
	public static class CommonFriendsTwoReducer extends Reducer<Text, Text, Text, Text>{
		

		@Override
		protected void reduce(Text friend, Iterable<Text> users, Context context)
				throws IOException, InterruptedException {
			
			StringBuilder stringBuilder=new StringBuilder();
			
			for(Text user: users){
				stringBuilder.append(user+",");
			}
			String substring = stringBuilder.substring(0, stringBuilder.length() - 1);
			context.write(new Text(friend),new Text(substring));

			
		}
		
	}
	
	
public static void main(String[] args) throws Exception {

		
		Configuration conf = new Configuration();  
		
		Job job = Job.getInstance(conf);

		job.setJarByClass(CommonFriendsTwo.class);

		job.setMapperClass(CommonFriendsTwoMapper.class);
		job.setReducerClass(CommonFriendsTwoReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		FileInputFormat.setInputPaths(job, new Path("D:\\transferStation\\tmp\\friends\\out1"));
		FileOutputFormat.setOutputPath(job, new Path("D:\\transferStation\\tmp\\friends\\out2"));

		job.waitForCompletion(true);
	}
}
