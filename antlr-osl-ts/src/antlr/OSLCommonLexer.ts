// Generated from ..\grammar\OSLCommonLexer.g4 by ANTLR 4.7.3-SNAPSHOT


import { ATN } from "antlr4ts/atn/ATN";
import { ATNDeserializer } from "antlr4ts/atn/ATNDeserializer";
import { CharStream } from "antlr4ts/CharStream";
import { Lexer } from "antlr4ts/Lexer";
import { LexerATNSimulator } from "antlr4ts/atn/LexerATNSimulator";
import { NotNull } from "antlr4ts/Decorators";
import { Override } from "antlr4ts/Decorators";
import { RuleContext } from "antlr4ts/RuleContext";
import { Vocabulary } from "antlr4ts/Vocabulary";
import { VocabularyImpl } from "antlr4ts/VocabularyImpl";

import * as Utils from "antlr4ts/misc/Utils";


export class OSLCommonLexer extends Lexer {
	public static readonly INTEGER = 1;
	public static readonly DECIMAL_NUMBER = 2;
	public static readonly TRUE = 3;
	public static readonly FALSE = 4;
	public static readonly NULL = 5;
	public static readonly BEGIN_LOCALE_STRING = 6;
	public static readonly BEGIN_QUOTED_STRING = 7;
	public static readonly BEGIN_ACTION = 8;
	public static readonly ESCAPES = 9;
	public static readonly STRING_CHARACTERS = 10;
	public static readonly QUOTED_STRING_VARIABLE_REFERENCE = 11;
	public static readonly BEGIN_LONG_QUOTED_COLOUR_CODE = 12;
	public static readonly QUOTED_COLOUR_CODE = 13;
	public static readonly END_QUOTED_STRING = 14;
	public static readonly LOCALE_NAME_SEPARATOR = 15;
	public static readonly LOCALE_NAME_IDENTIFIER = 16;
	public static readonly LOCALE_VARIABLE_REFERENCE = 17;
	public static readonly END_LOCALE_STRING = 18;
	public static readonly LONG_REF_ESCAPES = 19;
	public static readonly LONG_REF_CHARACTERS = 20;
	public static readonly LONG_REF_VARIABLE_REFERENCE = 21;
	public static readonly END_LONG_REFERENCE = 22;
	public static readonly ACTION_ESCAPES = 23;
	public static readonly ACTION_CHARACTERS = 24;
	public static readonly ACTION_VARIABLE_REFERENCE = 25;
	public static readonly END_ACTION = 26;
	public static readonly QuotedStringMode = 1;
	public static readonly LocaleStringMode = 2;
	public static readonly LongReferenceMode = 3;
	public static readonly ActionMode = 4;

	// tslint:disable:no-trailing-whitespace
	public static readonly channelNames: string[] = [
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN",
	];

	// tslint:disable:no-trailing-whitespace
	public static readonly modeNames: string[] = [
		"DEFAULT_MODE", "QuotedStringMode", "LocaleStringMode", "LongReferenceMode", 
		"ActionMode",
	];

	public static readonly ruleNames: string[] = [
		"VARIABLE_NAME_IDENTIFIER", "INTEGER", "DECIMAL_NUMBER", "TRUE", "FALSE", 
		"NULL", "BEGIN_LOCALE_STRING", "BEGIN_QUOTED_STRING", "BEGIN_ACTION", 
		"BINARY_DIGITS", "OCTAL_DIGITS", "DECIMAL_DIGITS", "HEX_DIGITS", "A", 
		"B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", 
		"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "INLINE_WHITESPACE_CHARACTERS", 
		"ESCAPES", "STRING_CHARACTERS", "QUOTED_STRING_VARIABLE_REFERENCE", "BEGIN_LONG_QUOTED_COLOUR_CODE", 
		"QUOTED_COLOUR_CODE", "COLOUR_CODE_CHARACTERS", "ESCAPE_CHARACTERS", "END_QUOTED_STRING", 
		"LOCALE_NAME_SEPARATOR", "LOCALE_NAME_IDENTIFIER", "LOCALE_VARIABLE_REFERENCE", 
		"END_LOCALE_STRING", "LONG_REF_ESCAPES", "LONG_REF_CHARACTERS", "LONG_REF_VARIABLE_REFERENCE", 
		"LONG_REF_ESCAPE_CHARACTERS", "END_LONG_REFERENCE", "ACTION_ESCAPES", 
		"ACTION_CHARACTERS", "ACTION_VARIABLE_REFERENCE", "ACTION_ESCAPE_CHARACTERS", 
		"END_ACTION",
	];

	private static readonly _LITERAL_NAMES: Array<string | undefined> = [
		undefined, undefined, undefined, undefined, undefined, undefined, "'\"locale.'", 
		undefined, "'['", undefined, undefined, undefined, "'&{'", undefined, 
		undefined, "'.'", undefined, undefined, undefined, undefined, undefined, 
		undefined, "'}'", undefined, undefined, undefined, "']'",
	];
	private static readonly _SYMBOLIC_NAMES: Array<string | undefined> = [
		undefined, "INTEGER", "DECIMAL_NUMBER", "TRUE", "FALSE", "NULL", "BEGIN_LOCALE_STRING", 
		"BEGIN_QUOTED_STRING", "BEGIN_ACTION", "ESCAPES", "STRING_CHARACTERS", 
		"QUOTED_STRING_VARIABLE_REFERENCE", "BEGIN_LONG_QUOTED_COLOUR_CODE", "QUOTED_COLOUR_CODE", 
		"END_QUOTED_STRING", "LOCALE_NAME_SEPARATOR", "LOCALE_NAME_IDENTIFIER", 
		"LOCALE_VARIABLE_REFERENCE", "END_LOCALE_STRING", "LONG_REF_ESCAPES", 
		"LONG_REF_CHARACTERS", "LONG_REF_VARIABLE_REFERENCE", "END_LONG_REFERENCE", 
		"ACTION_ESCAPES", "ACTION_CHARACTERS", "ACTION_VARIABLE_REFERENCE", "END_ACTION",
	];
	public static readonly VOCABULARY: Vocabulary = new VocabularyImpl(OSLCommonLexer._LITERAL_NAMES, OSLCommonLexer._SYMBOLIC_NAMES, []);

	// @Override
	// @NotNull
	public get vocabulary(): Vocabulary {
		return OSLCommonLexer.VOCABULARY;
	}
	// tslint:enable:no-trailing-whitespace


	constructor(input: CharStream) {
		super(input);
		this._interp = new LexerATNSimulator(OSLCommonLexer._ATN, this);
	}

	// @Override
	public get grammarFileName(): string { return "OSLCommonLexer.g4"; }

	// @Override
	public get ruleNames(): string[] { return OSLCommonLexer.ruleNames; }

	// @Override
	public get serializedATN(): string { return OSLCommonLexer._serializedATN; }

	// @Override
	public get channelNames(): string[] { return OSLCommonLexer.channelNames; }

	// @Override
	public get modeNames(): string[] { return OSLCommonLexer.modeNames; }

	public static readonly _serializedATN: string =
		"\x03\uC91D\uCABA\u058D\uAFBA\u4F53\u0607\uEA8B\uC241\x02\x1C\u0191\b\x01" +
		"\b\x01\b\x01\b\x01\b\x01\x04\x02\t\x02\x04\x03\t\x03\x04\x04\t\x04\x04" +
		"\x05\t\x05\x04\x06\t\x06\x04\x07\t\x07\x04\b\t\b\x04\t\t\t\x04\n\t\n\x04" +
		"\v\t\v\x04\f\t\f\x04\r\t\r\x04\x0E\t\x0E\x04\x0F\t\x0F\x04\x10\t\x10\x04" +
		"\x11\t\x11\x04\x12\t\x12\x04\x13\t\x13\x04\x14\t\x14\x04\x15\t\x15\x04" +
		"\x16\t\x16\x04\x17\t\x17\x04\x18\t\x18\x04\x19\t\x19\x04\x1A\t\x1A\x04" +
		"\x1B\t\x1B\x04\x1C\t\x1C\x04\x1D\t\x1D\x04\x1E\t\x1E\x04\x1F\t\x1F\x04" +
		" \t \x04!\t!\x04\"\t\"\x04#\t#\x04$\t$\x04%\t%\x04&\t&\x04\'\t\'\x04(" +
		"\t(\x04)\t)\x04*\t*\x04+\t+\x04,\t,\x04-\t-\x04.\t.\x04/\t/\x040\t0\x04" +
		"1\t1\x042\t2\x043\t3\x044\t4\x045\t5\x046\t6\x047\t7\x048\t8\x049\t9\x04" +
		":\t:\x04;\t;\x04<\t<\x04=\t=\x04>\t>\x04?\t?\x03\x02\x06\x02\x85\n\x02" +
		"\r\x02\x0E\x02\x86\x03\x03\x03\x03\x03\x03\x03\x03\x06\x03\x8D\n\x03\r" +
		"\x03\x0E\x03\x8E\x03\x03\x03\x03\x03\x03\x03\x03\x06\x03\x95\n\x03\r\x03" +
		"\x0E\x03\x96\x03\x03\x03\x03\x03\x03\x03\x03\x06\x03\x9D\n\x03\r\x03\x0E" +
		"\x03\x9E\x03\x03\x03\x03\x05\x03\xA3\n\x03\x03\x03\x06\x03\xA6\n\x03\r" +
		"\x03\x0E\x03\xA7\x05\x03\xAA\n\x03\x03\x04\x03\x04\x03\x04\x07\x04\xAF" +
		"\n\x04\f\x04\x0E\x04\xB2\v\x04\x05\x04\xB4\n\x04\x03\x04\x03\x04\x06\x04" +
		"\xB8\n\x04\r\x04\x0E\x04\xB9\x05\x04\xBC\n\x04\x03\x04\x03\x04\x05\x04" +
		"\xC0\n\x04\x03\x04\x06\x04\xC3\n\x04\r\x04\x0E\x04\xC4\x05\x04\xC7\n\x04" +
		"\x03\x05\x03\x05\x03\x05\x03\x05\x03\x05\x03\x06\x03\x06\x03\x06\x03\x06" +
		"\x03\x06\x03\x06\x03\x07\x03\x07\x03\x07\x03\x07\x03\x07\x03\b\x03\b\x03" +
		"\b\x03\b\x03\b\x03\b\x03\b\x03\b\x03\b\x03\b\x03\b\x03\t\x03\t\x03\t\x03" +
		"\t\x03\n\x03\n\x03\n\x03\n\x03\v\x03\v\x03\f\x03\f\x03\r\x03\r\x03\x0E" +
		"\x03\x0E\x03\x0F\x03\x0F\x03\x10\x03\x10\x03\x11\x03\x11\x03\x12\x03\x12" +
		"\x03\x13\x03\x13\x03\x14\x03\x14\x03\x15\x03\x15\x03\x16\x03\x16\x03\x17" +
		"\x03\x17\x03\x18\x03\x18\x03\x19\x03\x19\x03\x1A\x03\x1A\x03\x1B\x03\x1B" +
		"\x03\x1C\x03\x1C\x03\x1D\x03\x1D\x03\x1E\x03\x1E\x03\x1F\x03\x1F\x03 " +
		"\x03 \x03!\x03!\x03\"\x03\"\x03#\x03#\x03$\x03$\x03%\x03%\x03&\x03&\x03" +
		"\'\x03\'\x03(\x03(\x03)\x03)\x03*\x03*\x03*\x03*\x03*\x03*\x03*\x03*\x05" +
		"*\u0132\n*\x03+\x06+\u0135\n+\r+\x0E+\u0136\x03,\x03,\x03,\x03-\x03-\x03" +
		"-\x03-\x03-\x03.\x03.\x06.\u0143\n.\r.\x0E.\u0144\x03.\x05.\u0148\n.\x03" +
		"/\x03/\x030\x030\x031\x031\x031\x031\x032\x032\x033\x033\x034\x034\x03" +
		"5\x035\x035\x035\x036\x036\x036\x036\x036\x036\x036\x036\x056\u0164\n" +
		"6\x037\x067\u0167\n7\r7\x0E7\u0168\x038\x038\x068\u016D\n8\r8\x0E8\u016E" +
		"\x039\x039\x03:\x03:\x03:\x03:\x03;\x03;\x03;\x03;\x03;\x03;\x03;\x03" +
		";\x05;\u017F\n;\x03<\x06<\u0182\n<\r<\x0E<\u0183\x03=\x03=\x06=\u0188" +
		"\n=\r=\x0E=\u0189\x03>\x03>\x03?\x03?\x03?\x03?\x02\x02\x02@\x07\x02\x02" +
		"\t\x02\x03\v\x02\x04\r\x02\x05\x0F\x02\x06\x11\x02\x07\x13\x02\b\x15\x02" +
		"\t\x17\x02\n\x19\x02\x02\x1B\x02\x02\x1D\x02\x02\x1F\x02\x02!\x02\x02" +
		"#\x02\x02%\x02\x02\'\x02\x02)\x02\x02+\x02\x02-\x02\x02/\x02\x021\x02" +
		"\x023\x02\x025\x02\x027\x02\x029\x02\x02;\x02\x02=\x02\x02?\x02\x02A\x02" +
		"\x02C\x02\x02E\x02\x02G\x02\x02I\x02\x02K\x02\x02M\x02\x02O\x02\x02Q\x02" +
		"\x02S\x02\x02U\x02\x02W\x02\vY\x02\f[\x02\r]\x02\x0E_\x02\x0Fa\x02\x02" +
		"c\x02\x02e\x02\x10g\x02\x11i\x02\x12k\x02\x13m\x02\x14o\x02\x15q\x02\x16" +
		"s\x02\x17u\x02\x02w\x02\x18y\x02\x19{\x02\x1A}\x02\x1B\x7F\x02\x02\x81" +
		"\x02\x1C\x07\x02\x03\x04\x05\x06)\x06\x022;C\\aac|\x03\x023;\x04\x02G" +
		"Ggg\x04\x02--//\x03\x0223\x03\x0229\x03\x022;\x05\x022;CHch\x04\x02CC" +
		"cc\x04\x02DDdd\x04\x02EEee\x04\x02FFff\x04\x02HHhh\x04\x02IIii\x04\x02" +
		"JJjj\x04\x02KKkk\x04\x02LLll\x04\x02MMmm\x04\x02NNnn\x04\x02OOoo\x04\x02" +
		"PPpp\x04\x02QQqq\x04\x02RRrr\x04\x02SSss\x04\x02TTtt\x04\x02UUuu\x04\x02" +
		"VVvv\x04\x02WWww\x04\x02XXxx\x04\x02YYyy\x04\x02ZZzz\x04\x02[[{{\x04\x02" +
		"\\\\||\x04\x02\v\v\"\"\x06\x02$$&&((^^\f\x02$$&&((11^^ddhhppttvv\x05\x02" +
		"&&^^\x7F\x7F\v\x02&&11^^ddhhppttvv\x7F\x7F\x05\x02&&^_}}\x02\u0182\x02" +
		"\t\x03\x02\x02\x02\x02\v\x03\x02\x02\x02\x02\r\x03\x02\x02\x02\x02\x0F" +
		"\x03\x02\x02\x02\x02\x11\x03\x02\x02\x02\x02\x13\x03\x02\x02\x02\x02\x15" +
		"\x03\x02\x02\x02\x02\x17\x03\x02\x02\x02\x03W\x03\x02\x02\x02\x03Y\x03" +
		"\x02\x02\x02\x03[\x03\x02\x02\x02\x03]\x03\x02\x02\x02\x03_\x03\x02\x02" +
		"\x02\x03e\x03\x02\x02\x02\x04g\x03\x02\x02\x02\x04i\x03\x02\x02\x02\x04" +
		"k\x03\x02\x02\x02\x04m\x03\x02\x02\x02\x05o\x03\x02\x02\x02\x05q\x03\x02" +
		"\x02\x02\x05s\x03\x02\x02\x02\x05w\x03\x02\x02\x02\x06y\x03\x02\x02\x02" +
		"\x06{\x03\x02\x02\x02\x06}\x03\x02\x02\x02\x06\x81\x03\x02\x02\x02\x07" +
		"\x84\x03\x02\x02\x02\t\xA9\x03\x02\x02\x02\v\xB3\x03\x02\x02\x02\r\xC8" +
		"\x03\x02\x02\x02\x0F\xCD\x03\x02\x02\x02\x11\xD3\x03\x02\x02\x02\x13\xD8" +
		"\x03\x02\x02\x02\x15\xE3\x03\x02\x02\x02\x17\xE7\x03\x02\x02\x02\x19\xEB" +
		"\x03\x02\x02\x02\x1B\xED\x03\x02\x02\x02\x1D\xEF\x03\x02\x02\x02\x1F\xF1" +
		"\x03\x02\x02\x02!\xF3\x03\x02\x02\x02#\xF5\x03\x02\x02\x02%\xF7\x03\x02" +
		"\x02\x02\'\xF9\x03\x02\x02\x02)\xFB\x03\x02\x02\x02+\xFD\x03\x02\x02\x02" +
		"-\xFF\x03\x02\x02\x02/\u0101\x03\x02\x02\x021\u0103\x03\x02\x02\x023\u0105" +
		"\x03\x02\x02\x025\u0107\x03\x02\x02\x027\u0109\x03\x02\x02\x029\u010B" +
		"\x03\x02\x02\x02;\u010D\x03\x02\x02\x02=\u010F\x03\x02\x02\x02?\u0111" +
		"\x03\x02\x02\x02A\u0113\x03\x02\x02\x02C\u0115\x03\x02\x02\x02E\u0117" +
		"\x03\x02\x02\x02G\u0119\x03\x02\x02\x02I\u011B\x03\x02\x02\x02K\u011D" +
		"\x03\x02\x02\x02M\u011F\x03\x02\x02\x02O\u0121\x03\x02\x02\x02Q\u0123" +
		"\x03\x02\x02\x02S\u0125\x03\x02\x02\x02U\u0127\x03\x02\x02\x02W\u0129" +
		"\x03\x02\x02\x02Y\u0134\x03\x02\x02\x02[\u0138\x03\x02\x02\x02]\u013B" +
		"\x03\x02\x02\x02_\u0140\x03\x02\x02\x02a\u0149\x03\x02\x02\x02c\u014B" +
		"\x03\x02\x02\x02e\u014D\x03\x02\x02\x02g\u0151\x03\x02\x02\x02i\u0153" +
		"\x03\x02\x02\x02k\u0155\x03\x02\x02\x02m\u0157\x03\x02\x02\x02o\u015B" +
		"\x03\x02\x02\x02q\u0166\x03\x02\x02\x02s\u016A\x03\x02\x02\x02u\u0170" +
		"\x03\x02\x02\x02w\u0172\x03\x02\x02\x02y\u0176\x03\x02\x02\x02{\u0181" +
		"\x03\x02\x02\x02}\u0185\x03\x02\x02\x02\x7F\u018B\x03\x02\x02\x02\x81" +
		"\u018D\x03\x02\x02\x02\x83\x85\t\x02\x02\x02\x84\x83\x03\x02\x02\x02\x85" +
		"\x86\x03\x02\x02\x02\x86\x84\x03\x02\x02\x02\x86\x87\x03\x02\x02\x02\x87" +
		"\b\x03\x02\x02\x02\x88\x89\x072\x02\x02\x89\x8A\x07d\x02\x02\x8A\x8C\x03" +
		"\x02\x02\x02\x8B\x8D\x05\x19\v\x02\x8C\x8B\x03\x02\x02\x02\x8D\x8E\x03" +
		"\x02\x02\x02\x8E\x8C\x03\x02\x02\x02\x8E\x8F\x03\x02\x02\x02\x8F\xAA\x03" +
		"\x02\x02\x02\x90\x91\x072\x02\x02\x91\x92\x07q\x02\x02\x92\x94\x03\x02" +
		"\x02\x02\x93\x95\x05\x1B\f\x02\x94\x93\x03\x02\x02\x02\x95\x96\x03\x02" +
		"\x02\x02\x96\x94\x03\x02\x02\x02\x96\x97\x03\x02\x02\x02\x97\xAA\x03\x02" +
		"\x02\x02\x98\x99\x072\x02\x02\x99\x9A\x07z\x02\x02\x9A\x9C\x03\x02\x02" +
		"\x02\x9B\x9D\x05\x1F\x0E\x02\x9C\x9B\x03\x02\x02\x02\x9D\x9E\x03\x02\x02" +
		"\x02\x9E\x9C\x03\x02\x02\x02\x9E\x9F\x03\x02\x02\x02\x9F\xAA\x03\x02\x02" +
		"\x02\xA0\xA1\x072\x02\x02\xA1\xA3\x07f\x02\x02\xA2\xA0\x03\x02\x02\x02" +
		"\xA2\xA3\x03\x02\x02\x02\xA3\xA5\x03\x02\x02\x02\xA4\xA6\x05\x1D\r\x02" +
		"\xA5\xA4\x03\x02\x02\x02\xA6\xA7\x03\x02\x02\x02\xA7\xA5\x03\x02\x02\x02" +
		"\xA7\xA8\x03\x02\x02\x02\xA8\xAA\x03\x02\x02\x02\xA9\x88\x03\x02\x02\x02" +
		"\xA9\x90\x03\x02\x02\x02\xA9\x98\x03\x02\x02\x02\xA9\xA2\x03\x02\x02\x02" +
		"\xAA\n\x03\x02\x02\x02\xAB\xB4\x072\x02\x02\xAC\xB0\t\x03\x02\x02\xAD" +
		"\xAF\x05\x1D\r\x02\xAE\xAD\x03\x02\x02\x02\xAF\xB2\x03\x02\x02\x02\xB0" +
		"\xAE\x03\x02\x02\x02\xB0\xB1\x03\x02\x02\x02\xB1\xB4\x03\x02\x02\x02\xB2" +
		"\xB0\x03\x02\x02\x02\xB3\xAB\x03\x02\x02\x02\xB3\xAC\x03\x02\x02\x02\xB4" +
		"\xBB\x03\x02\x02\x02\xB5\xB7\x070\x02\x02\xB6\xB8\x05\x1D\r\x02\xB7\xB6" +
		"\x03\x02\x02\x02\xB8\xB9\x03\x02\x02\x02\xB9\xB7\x03\x02\x02\x02\xB9\xBA" +
		"\x03\x02\x02\x02\xBA\xBC\x03\x02\x02\x02\xBB\xB5\x03\x02\x02\x02\xBB\xBC" +
		"\x03\x02\x02\x02\xBC\xC6\x03\x02\x02\x02\xBD\xBF\t\x04\x02\x02\xBE\xC0" +
		"\t\x05\x02\x02\xBF\xBE\x03\x02\x02\x02\xBF\xC0\x03\x02\x02\x02\xC0\xC2" +
		"\x03\x02\x02\x02\xC1\xC3\x05\x1D\r\x02\xC2\xC1\x03\x02\x02\x02\xC3\xC4" +
		"\x03\x02\x02\x02\xC4\xC2\x03\x02\x02\x02\xC4\xC5\x03\x02\x02\x02\xC5\xC7" +
		"\x03\x02\x02\x02\xC6\xBD\x03\x02\x02\x02\xC6\xC7\x03\x02\x02\x02\xC7\f" +
		"\x03\x02\x02\x02\xC8\xC9\x05G\"\x02\xC9\xCA\x05C \x02\xCA\xCB\x05I#\x02" +
		"\xCB\xCC\x05)\x13\x02\xCC\x0E\x03\x02\x02\x02\xCD\xCE\x05+\x14\x02\xCE" +
		"\xCF\x05!\x0F\x02\xCF\xD0\x057\x1A\x02\xD0\xD1\x05E!\x02\xD1\xD2\x05)" +
		"\x13\x02\xD2\x10\x03\x02\x02\x02\xD3\xD4\x05;\x1C\x02\xD4\xD5\x05I#\x02" +
		"\xD5\xD6\x057\x1A\x02\xD6\xD7\x057\x1A\x02\xD7\x12\x03\x02\x02\x02\xD8" +
		"\xD9\x07$\x02\x02\xD9\xDA\x07n\x02\x02\xDA\xDB\x07q\x02\x02\xDB\xDC\x07" +
		"e\x02\x02\xDC\xDD\x07c\x02\x02\xDD\xDE\x07n\x02\x02\xDE\xDF\x07g\x02\x02" +
		"\xDF\xE0\x070\x02\x02\xE0\xE1\x03\x02\x02\x02\xE1\xE2\b\b\x02\x02\xE2" +
		"\x14\x03\x02\x02\x02\xE3\xE4\x07$\x02\x02\xE4\xE5\x03\x02\x02\x02\xE5" +
		"\xE6\b\t\x03\x02\xE6\x16\x03\x02\x02\x02\xE7\xE8\x07]\x02\x02\xE8\xE9" +
		"\x03\x02\x02\x02\xE9\xEA\b\n\x04\x02\xEA\x18\x03\x02\x02\x02\xEB\xEC\t" +
		"\x06\x02\x02\xEC\x1A\x03\x02\x02\x02\xED\xEE\t\x07\x02\x02\xEE\x1C\x03" +
		"\x02\x02\x02\xEF\xF0\t\b\x02\x02\xF0\x1E\x03\x02\x02\x02\xF1\xF2\t\t\x02" +
		"\x02\xF2 \x03\x02\x02\x02\xF3\xF4\t\n\x02\x02\xF4\"\x03\x02\x02\x02\xF5" +
		"\xF6\t\v\x02\x02\xF6$\x03\x02\x02\x02\xF7\xF8\t\f\x02\x02\xF8&\x03\x02" +
		"\x02\x02\xF9\xFA\t\r\x02\x02\xFA(\x03\x02\x02\x02\xFB\xFC\t\x04\x02\x02" +
		"\xFC*\x03\x02\x02\x02\xFD\xFE\t\x0E\x02\x02\xFE,\x03\x02\x02\x02\xFF\u0100" +
		"\t\x0F\x02\x02\u0100.\x03\x02\x02\x02\u0101\u0102\t\x10\x02\x02\u0102" +
		"0\x03\x02\x02\x02\u0103\u0104\t\x11\x02\x02\u01042\x03\x02\x02\x02\u0105" +
		"\u0106\t\x12\x02\x02\u01064\x03\x02\x02\x02\u0107\u0108\t\x13\x02\x02" +
		"\u01086\x03\x02\x02\x02\u0109\u010A\t\x14\x02\x02\u010A8\x03\x02\x02\x02" +
		"\u010B\u010C\t\x15\x02\x02\u010C:\x03\x02\x02\x02\u010D\u010E\t\x16\x02" +
		"\x02\u010E<\x03\x02\x02\x02\u010F\u0110\t\x17\x02\x02\u0110>\x03\x02\x02" +
		"\x02\u0111\u0112\t\x18\x02\x02\u0112@\x03\x02\x02\x02\u0113\u0114\t\x19" +
		"\x02\x02\u0114B\x03\x02\x02\x02\u0115\u0116\t\x1A\x02\x02\u0116D\x03\x02" +
		"\x02\x02\u0117\u0118\t\x1B\x02\x02\u0118F\x03\x02\x02\x02\u0119\u011A" +
		"\t\x1C\x02\x02\u011AH\x03\x02\x02\x02\u011B\u011C\t\x1D\x02\x02\u011C" +
		"J\x03\x02\x02\x02\u011D\u011E\t\x1E\x02\x02\u011EL\x03\x02\x02\x02\u011F" +
		"\u0120\t\x1F\x02\x02\u0120N\x03\x02\x02\x02\u0121\u0122\t \x02\x02\u0122" +
		"P\x03\x02\x02\x02\u0123\u0124\t!\x02\x02\u0124R\x03\x02\x02\x02\u0125" +
		"\u0126\t\"\x02\x02\u0126T\x03\x02\x02\x02\u0127\u0128\t#\x02\x02\u0128" +
		"V\x03\x02\x02\x02\u0129\u0131\x07^\x02\x02\u012A\u012B\x07w\x02\x02\u012B" +
		"\u012C\x05\x1F\x0E\x02\u012C\u012D\x05\x1F\x0E\x02\u012D\u012E\x05\x1F" +
		"\x0E\x02\u012E\u012F\x05\x1F\x0E\x02\u012F\u0132\x03\x02\x02\x02\u0130" +
		"\u0132\x05c0\x02\u0131\u012A\x03\x02\x02\x02\u0131\u0130\x03\x02\x02\x02" +
		"\u0132X\x03\x02\x02\x02\u0133\u0135\n$\x02\x02\u0134\u0133\x03\x02\x02" +
		"\x02\u0135\u0136\x03\x02\x02\x02\u0136\u0134\x03\x02\x02\x02\u0136\u0137" +
		"\x03\x02\x02\x02\u0137Z\x03\x02\x02\x02\u0138\u0139\x07&\x02\x02\u0139" +
		"\u013A\x05\x07\x02\x02\u013A\\\x03\x02\x02\x02\u013B\u013C\x07(\x02\x02" +
		"\u013C\u013D\x07}\x02\x02\u013D\u013E\x03\x02\x02\x02\u013E\u013F\b-\x05" +
		"\x02\u013F^\x03\x02\x02\x02\u0140\u0142\x07(\x02\x02\u0141\u0143\x05a" +
		"/\x02\u0142\u0141\x03\x02\x02\x02\u0143\u0144\x03\x02\x02\x02\u0144\u0142" +
		"\x03\x02\x02\x02\u0144\u0145\x03\x02\x02\x02\u0145\u0147\x03\x02\x02\x02" +
		"\u0146\u0148\x05U)\x02\u0147\u0146\x03\x02\x02\x02\u0147\u0148\x03\x02" +
		"\x02\x02\u0148`\x03\x02\x02\x02\u0149\u014A\t\x02\x02\x02\u014Ab\x03\x02" +
		"\x02\x02\u014B\u014C\t%\x02\x02\u014Cd\x03\x02\x02\x02\u014D\u014E\x07" +
		"$\x02\x02\u014E\u014F\x03\x02\x02\x02\u014F\u0150\b1\x06\x02\u0150f\x03" +
		"\x02\x02\x02\u0151\u0152\x070\x02\x02\u0152h\x03\x02\x02\x02\u0153\u0154" +
		"\x05\x07\x02\x02\u0154j\x03\x02\x02\x02\u0155\u0156\x05[,\x02\u0156l\x03" +
		"\x02\x02\x02\u0157\u0158\x07$\x02\x02\u0158\u0159\x03\x02\x02\x02\u0159" +
		"\u015A\b5\x06\x02\u015An\x03\x02\x02\x02\u015B\u0163\x07^\x02\x02\u015C" +
		"\u015D\x07w\x02\x02\u015D\u015E\x05\x1F\x0E\x02\u015E\u015F\x05\x1F\x0E" +
		"\x02\u015F\u0160\x05\x1F\x0E\x02\u0160\u0161\x05\x1F\x0E\x02\u0161\u0164" +
		"\x03\x02\x02\x02\u0162\u0164\x05u9\x02\u0163\u015C\x03\x02\x02\x02\u0163" +
		"\u0162\x03\x02\x02\x02\u0164p\x03\x02\x02\x02\u0165\u0167\n&\x02\x02\u0166" +
		"\u0165\x03\x02\x02\x02\u0167\u0168\x03\x02\x02\x02\u0168\u0166\x03\x02" +
		"\x02\x02\u0168\u0169\x03\x02\x02\x02\u0169r\x03\x02\x02\x02\u016A\u016C" +
		"\x07&\x02\x02\u016B\u016D\t\x02\x02\x02\u016C\u016B\x03\x02\x02\x02\u016D" +
		"\u016E\x03\x02\x02\x02\u016E\u016C\x03\x02\x02\x02\u016E\u016F\x03\x02" +
		"\x02\x02\u016Ft\x03\x02\x02\x02\u0170\u0171\t\'\x02\x02\u0171v\x03\x02" +
		"\x02\x02\u0172\u0173\x07\x7F\x02\x02\u0173\u0174\x03\x02\x02\x02\u0174" +
		"\u0175\b:\x06\x02\u0175x\x03\x02\x02\x02\u0176\u017E\x07^\x02\x02\u0177" +
		"\u0178\x07w\x02\x02\u0178\u0179\x05\x1F\x0E\x02\u0179\u017A\x05\x1F\x0E" +
		"\x02\u017A\u017B\x05\x1F\x0E\x02\u017B\u017C\x05\x1F\x0E\x02\u017C\u017F" +
		"\x03\x02\x02\x02\u017D\u017F\x05\x7F>\x02\u017E\u0177\x03\x02\x02\x02" +
		"\u017E\u017D\x03\x02\x02\x02\u017Fz\x03\x02\x02\x02\u0180\u0182\n(\x02" +
		"\x02\u0181\u0180\x03\x02\x02\x02\u0182\u0183\x03\x02\x02\x02\u0183\u0181" +
		"\x03\x02\x02\x02\u0183\u0184\x03\x02\x02\x02\u0184|\x03\x02\x02\x02\u0185" +
		"\u0187\x07&\x02\x02\u0186\u0188\t\x02\x02\x02\u0187\u0186\x03\x02\x02" +
		"\x02\u0188\u0189\x03\x02\x02\x02\u0189\u0187\x03\x02\x02\x02\u0189\u018A" +
		"\x03\x02\x02\x02\u018A~\x03\x02\x02\x02\u018B\u018C\t\'\x02\x02\u018C" +
		"\x80\x03\x02\x02\x02\u018D\u018E\x07_\x02\x02\u018E\u018F\x03\x02\x02" +
		"\x02\u018F\u0190\b?\x06\x02\u0190\x82\x03\x02\x02\x02\x1F\x02\x03\x04" +
		"\x05\x06\x86\x8E\x96\x9E\xA2\xA7\xA9\xB0\xB3\xB9\xBB\xBF\xC4\xC6\u0131" +
		"\u0136\u0144\u0147\u0163\u0168\u016E\u017E\u0183\u0189\x07\x07\x04\x02" +
		"\x07\x03\x02\x07\x06\x02\x07\x05\x02\x06\x02\x02";
	public static __ATN: ATN;
	public static get _ATN(): ATN {
		if (!OSLCommonLexer.__ATN) {
			OSLCommonLexer.__ATN = new ATNDeserializer().deserialize(Utils.toCharArray(OSLCommonLexer._serializedATN));
		}

		return OSLCommonLexer.__ATN;
	}

}

