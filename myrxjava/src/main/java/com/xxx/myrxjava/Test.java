/**
 * 
 */
package com.xxx.myrxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * @author JIAHCH
 *
 *         2018年5月14日 下午3:26:07
 */
public class Test {
	
	private static Logger logger = LoggerFactory.getLogger(Test.class);
	
	
	public Observable<List<Integer>> observable(List<Integer> items){
		
		return Observable.fromArray(items);
	}
	
	
	Subscriber<List<Integer>> subs = new Subscriber<List<Integer>>(){

		@Override
		public void onComplete() {
			
		}

		@Override
		public void onError(Throwable arg0) {
			
		}

		@Override
		public void onNext(List<Integer> arg0) {
			
		}

		@Override
		public void onSubscribe(Subscription arg0) {
			
		}
		
	} ;
	
	private void test2(){
		
		Observable.create(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> e)
					throws Exception {
				e.onNext(1);
				logger.info("next com1");
				e.onNext(2);
				logger.info("next com2");
				e.onNext(3);
			}
		}).map(new Function<Integer, String>() {
			@Override
			public String apply(@NonNull Integer integer) throws Exception {
				return "This is result " + integer;
			}
		}).subscribe(new Consumer<String>() {
			StringBuffer mRxOperatorsText  = new StringBuffer(); 
			@Override
			public void accept(@NonNull String s) throws Exception {
				
				Thread.sleep(1000);
				mRxOperatorsText.append("accept : " + s + "\n");
				logger.info("accept : " + s + "\n");
			}
		});
		
	}
	
	
	private void test(){
		
		List<Integer> items = Lists.newArrayList(1 , 3 ,5 , 7 );
		Observable<List<Integer>> observable = observable(items);
		observable.subscribe(
			    v -> System.out.println("Received: " + v),
			    e -> System.out.println("Error: " + e),
			    () -> System.out.println("Completed")
			);
	}
	
	

	public static void main(String[] args) {

		Test test = new Test();
		test.test();

	}

}
