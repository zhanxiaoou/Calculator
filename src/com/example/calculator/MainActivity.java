package com.example.calculator;



import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	double sum = 0;//��¼���ս����Ĭ��Ϊ0
	//BigDecimal fault;

	double data1 = 0;//��¼����������1(�����֮ǰ)��Ĭ��Ϊ0
	double data2 = 0;//��¼����������2�������֮�󣩣�Ĭ��Ϊ0
	int option = 0;//��¼�����״̬��Ĭ��Ϊ0
	int point = 0;//��¼�Ƿ���С����Ĭ��Ϊ0
	int state = 0;//state���������ã�����������ʱstate==1,�����ı�������Ϊ0���ٻ�ȡ��ť�ַ��������������ʱstate==1,�轫�����״̬����Ϊ0��
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//����activityҳ�棬���ر�����
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		

		//��ť����1
		Button button1 = (Button)findViewById(R.id.number1);
		button1.setOnClickListener(listener);
		//��ť����2
		Button button2 = (Button)findViewById(R.id.number2);
		button2.setOnClickListener(listener);
		//��ť����3
		Button button3 = (Button)findViewById(R.id.number3);
		button3.setOnClickListener(listener);
		//��ť����4
		Button button4 = (Button)findViewById(R.id.number4);
		button4.setOnClickListener(listener);
		//��ť����5
		Button button5 = (Button)findViewById(R.id.number5);
		button5.setOnClickListener(listener);
		//��ť����6
		Button button6 = (Button)findViewById(R.id.number6);
		button6.setOnClickListener(listener);
		//��ť����7
		Button button7 = (Button)findViewById(R.id.number7);
		button7.setOnClickListener(listener);
		//��ť����8
		Button button8 = (Button)findViewById(R.id.number8);
		button8.setOnClickListener(listener);
		//��ť����9
		Button button9 = (Button)findViewById(R.id.number9);
		button9.setOnClickListener(listener);
		//��ť����0
		Button button0 = (Button)findViewById(R.id.number0);
		button0.setOnClickListener(listener);
		//��ť��+��
		Button buttonplus = (Button)findViewById(R.id.plus);
		buttonplus.setOnClickListener(listener);
		//��ť��-��
		Button buttonminus = (Button)findViewById(R.id.minus);
		buttonminus.setOnClickListener(listener);
		//��ť��*��
		Button buttontimes = (Button)findViewById(R.id.times);
		buttontimes.setOnClickListener(listener);
		//��ť��/��
		Button buttondivided = (Button)findViewById(R.id.divided);
		buttondivided.setOnClickListener(listener);
		//��ť"."
		Button buttondecimal = (Button)findViewById(R.id.decimal);
		buttondecimal.setOnClickListener(listener);
		//��ť"="
		Button buttonis = (Button)findViewById(R.id.is);
		buttonis.setOnClickListener(listener);
		//��ť"AC"
		Button buttonclean = (Button)findViewById(R.id.clean);
		buttonclean.setOnClickListener(listener);
		//��ť"Back"
		Button buttonback = (Button)findViewById(R.id.back);
		buttonback.setOnClickListener(listener);
	}
		//ʵ������������listener
	OnClickListener listener = new OnClickListener(){

		@Override
		public void onClick(View v) {
				
		TextView text = (TextView)findViewById(R.id.textview);//ʵ�����ı������
		String t = text.getText().toString();//��ȡ�ı�����ַ�����t��text
		Button b = (Button) v;//ʵ������ť����,b��button
		

	
	
		//�������֣�����0-9��С���㣩
		if(b.getId()==R.id.number1 || b.getId()==R.id.number2 || b.getId()==R.id.number3 || b.getId()==R.id.number4 || b.getId()==R.id.number5 ||
		   b.getId()==R.id.number6 || b.getId()==R.id.number7 || b.getId()==R.id.number8 || b.getId()==R.id.number9 || b.getId()==R.id.number0 ||
		   b.getId()==R.id.decimal){//��������������ֻ���С����
			
			if(state==1){//����������ʱstate==1,�����ı�������Ϊ0���ٻ�ȡ��ť�ַ���
			   t = "0";
			   state = 0;
		    }
			
			if(t.length()<11){//�ı����ַ�������С�ڵ���11λʱ
				
				if(b.getId()!=R.id.decimal){//��������ʱ
					if(t.equals("0")){
						//���ı���Ϊ�㣬��0�滻Ϊ��ȡ���İ�ť�ַ�
						t=(String) b.getText();
					}

					else//�ı���Ϊ�㣬ֱ�ӽ���ȡ���İ�ť�ַ���ӵ��ı����ַ�������
						t=t+b.getText();
						
				}
				else{//����С����ʱ�����point == 0������ǰû��С���㣩�����С���㣬��֮�����κβ������������ظ����С���㣩��			
					if(point == 0)
						t=t+b.getText();
						point = 1;			
				}				
			}			
			text.setText(t);//�ı���չʾ�����µ��ַ���
		}
		
		
		
		
		//�����˸����
		if(b.getId()==R.id.back){
			//���ж��ı����ı��Ƿ�Ϊ��
			if(t.equals("")||t==null){
				text.setText("");
			}
			else{
				t=t.substring(0,t.length()-1);//�˸��Լ��ַ�
				
				//���˸�֮���ַ��������Ƿ�Ϊ��
				if(t.length()==0){
					
				text.setText("");
					
				}
				else//����ֱ�Ӵ�ӡ���ַ���
					text.setText(t);				
			}
				
		}
		
		
		
		
	
		//������������Ӽ��˳���
		if(b.getId()==R.id.plus || b.getId()==R.id.minus || b.getId()==R.id.times || b.getId()==R.id.divided){
			if(state == 1 ){
				option = 0;
			}
			//�������״̬��Ϊ1ʱ�����м��㣬��ʱ����������൱�ڵȺ�
			if(option!=0){
				//����ǰ�ı������ݸ�ֵ��data2
				try{//��t==nullʱ��Double.valueOf(t)���׳�NumberFormatException
					data2 = Double.valueOf(t);
					BigDecimal b1 = new BigDecimal(Double.toString(data1));
					BigDecimal b2 = new BigDecimal(Double.toString(data2));
					
					switch (option){
						case 1:
							//fault = b1.add(b2);
							sum = b1.add(b2).doubleValue();
							//sum = data1 + data2;
							break;
						case 2:
							//fault = b1.subtract(b2);
							sum = b1.subtract(b2).doubleValue();
							//sum = data1 - data2;
							break;
						case 3:
							//fault = b1.multiply(b2);
							sum = b1.multiply(b2).doubleValue();
							//sum = data1 * data2;
							break;
						case 4:
							if(data2==0){
								Toast.makeText(MainActivity.this,"0����������",Toast.LENGTH_LONG).show();
								sum = 0;
							}
							else
								//fault = b1.divide(b2);
								sum= b1.divide(b2,10,BigDecimal.ROUND_DOWN).doubleValue(); 	
								//sum=data1/data2;
							break;			
					}
					
					/**if(option==1){//��
						sum = data1 + data2;
						
					}
					if(option==2){//��
						sum = data1 - data2;
						
					}
					if(option==3){//��
						sum = data1 * data2;
	
					}
					if(option==4){//��
						if(data2==0){
							Toast.makeText(MainActivity.this,"0����������",Toast.LENGTH_SHORT).show();
							sum = 0;
						
						}
						else
						sum=data1/data2;
						
					}*/
					//sum = fault.doubleValue();
					
					data1 = sum;
					state = 1;
					//�˴�û�н�option����Ϊ0������Ϊ����ȥ�����ʵ�ʰ�ť��������option
					
					if(sum==0.0d)//���Ϊ0.0dʱ���ı���չʾΪ"0"
						text.setText("0");
					else if(sum%1 == 0.0d){//���û��С��ʱ���ı���չʾΪ����
						DecimalFormat form = new DecimalFormat("#");
						text.setText(form.format(sum));
					}	
					else{//��ʵ�ʽ��չʾ
						text.setText(String.valueOf(sum));

					}

				}
				catch(NumberFormatException e){//��Double.valueOf(t)���׳�NumberFormatException��ִ���·����
					
					
					/**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="��";
					
					text.setText(s);
					*/
					
					
					text.setText("");
					state = 1;
					
					
					
				}
			}	
			
			//��optionΪ��ʱ������ǰ�ı������ַ�����ֵ��data1
			else{				
				try{//��t==nullʱ��Double.valueOf(t)���׳�NumberFormatException
					data1 = Double.valueOf(t);
					/**String s = null;
					if(b.getId()==R.id.plus)
						s="+";
								
					if(b.getId()==R.id.minus)
						s="-";
								
					if(b.getId()==R.id.times)
						s="x";
								
					if(b.getId()==R.id.divided)
						s="��";
					
					text.setText(s);
					*/
					
					
					text.setText(t);
					state = 1;
				}
				catch(NumberFormatException e){//��Double.valueOf(t)���׳�NumberFormatException��ִ���·����
					text.setText(t);
					state = 1;
				}

			}
			//������������������option	
			if(b.getId()==R.id.plus)
				option=1;
						
			if(b.getId()==R.id.minus)
				option=2;
						
			if(b.getId()==R.id.times)
				option=3;
						
			if(b.getId()==R.id.divided)
				option=4;
			
			point = 0;
		}
		//������ں�
		if(b.getId()==R.id.is){
		 	
			//��option��Ϊ��ʱ����option������Ӧ����
			if(option!=0){
				
				try{
				data2 = Double.valueOf(t);
				BigDecimal b1 = new BigDecimal(Double.toString(data1));
				BigDecimal b2 = new BigDecimal(Double.toString(data2));
				
				switch (option){
					case 1:

						sum = b1.add(b2).doubleValue();
						//sum = data1 + data2;
						break;
					case 2:
						sum = b1.subtract(b2).doubleValue();
						//sum = data1 - data2;
						break;
					case 3:
						sum = b1.multiply(b2).doubleValue();
						//sum = data1 * data2;
						break;
					case 4:
						if(data2==0){
							Toast.makeText(MainActivity.this,"0����������",Toast.LENGTH_LONG).show();
							sum = 0;
						}
						else
						sum= b1.divide(b2,10,BigDecimal.ROUND_DOWN).doubleValue(); 	
						//sum=data1/data2;							
						break;			
				}
				
				data1 = sum;
				option = 0;
				state = 1;
				
				
				if(sum==0.0d)//���Ϊ0.0dʱ���ı���չʾΪ"0"
					text.setText("0");
				else if(sum%1 == 0.0d){//���û��С��ʱ���ı���չʾΪ����
					DecimalFormat form = new DecimalFormat("#");
					text.setText(form.format(sum));
					}	
				else//��ʵ�ʽ��չʾ
					text.setText(String.valueOf(sum));
					
				}
				catch(NumberFormatException e){
					
					text.setText(t);
					state = 1;
				}
			}	
			
			//optionΪ�㣬ֱ��չʾ�ı�������
			else{	
				
				text.setText(t);
				state = 1;
			}
	
		}
		//����������ţ�������ȫ�ֱ�������Ϊ0���ı������
		if(b.getId()==R.id.clean){
			sum = 0;
			data1 = 0;
			data2 = 0;
			option = 0;
			point = 0;
			state = 0;
			
			text.setText("0");//�ı������
		}
	}};

}
