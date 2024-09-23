package org.jsp.app.excption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserNotFoundException extends RuntimeException{
		private  String message;
		public UserNotFoundException() {
			super("No User Data Found ");
		}
		public UserNotFoundException(String message) {
			this.message=message;
		}
		@Override
		public String toString() {
			return this.message;
		}
		
}
