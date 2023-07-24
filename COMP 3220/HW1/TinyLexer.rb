#
#  Class Lexer - Reads a TINY program and emits tokens
#
class Lexer
	# Constructor - Is passed a file to scan and outputs a token
	#               each time nextToken() is invoked.
	#   @c        - A one character lookahead 
		def initialize(filename)
			# Need to modify this code so that the program
			# doesn't abend if it can't open the file but rather
			# displays an informative message
			if !(File.exists?(filename))
				puts "can't open file. Did you type in file correctly?"
				
				exit
			
			else
	
				@f = File.open(filename,'r:utf-8')
	
			end
			
			# Go ahead and read in the first character in the source
			# code file (if there is one) so that you can begin
			# lexing the source code file 
			if (! @f.eof?)
				@c = @f.getc()
			else
				@c = "eof"
				@f.close()
			end
	
		end
		
		# Method nextCh() returns the next character in the file
		def nextCh()
			if (! @f.eof?)
				@c = @f.getc()
			else
				@c = "eof"
			end
			
			return @c
		end
	
		# Method nextToken() reads characters in the file and returns
		# the next token
		def nextToken() 
	
			if @c == "eof"
				return Token.new(Token::EOF,"eof")
				exit
			elsif (whitespace?(@c))
				str = ""
			
				while whitespace?(@c)
					str += @c
					nextCh()
				end
			
				tok = Token.new(Token::WS,str)
				
	
			 elsif  letter?(@c)
				str = ""
	
				while letter?(@c)
					str += @c
					nextCh()
				end
	
				if str == "print"
	
					tok = Token.new(Token::PRINT,str)
	
				else
	
					tok = Token.new(Token::ID,str)
				
				end
	
			elsif numeric?(@c)
				str = ""
				
				while numeric?(@c)
					str += @c
					nextCh()
				end
	
				tok = Token.new(Token::INT, str)
			
			
			else
				case @c
	
				when "+"
					tok = Token.new(Token::ADDOP, @c)
				
				when "-"
					tok = Token.new(Token::MINUS, @c)
				
				when "/"
					tok = Token.new(Token::DIV, @c)
	
				when "*"
					tok = Token.new(Token::MULT, @c)
	
				when "("
					tok = Token.new(Token::LPAREN, @c)
	
				when ")"
					tok = Token.new(Token::RPAREN, @c)
	
				when "="
					tok = Token.new(Token::ASSIGN, @c)
	
				else
					tok = Token.new(Token::UNKNWN, @c)
				end
			
				nextCh()	
			end
			
			puts "Next token is: #{tok.type} Next Lexeme is: #{tok.text}"
			
			return tok
		end	
	
	
	end
	
	#
	# Helper methods for Scanner
	#
	def letter?(lookAhead)
		lookAhead =~ /^[a-z]|[A-Z]$/
	end
	
	def numeric?(lookAhead)
			lookAhead =~ /^(\d)+$/
	end
	
	def whitespace?(lookAhead)
		lookAhead =~ /^(\s)+$/
	end